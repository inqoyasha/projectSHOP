/*
 * Copyright (c) 2019-2020, Aamat.org
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *
 * modification, are permitted provided that the following conditions
 *
 * are met: no conditions.
 */

package org.azamat.controller;

import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import org.azamat.exception.ProductNotFoundException;
import org.azamat.service.CheckoutService;
import org.azamat.service.OrderProductService;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This is CheckoutController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
public class CheckoutController {
    // @checkstyle MemberNameCheck (15 lines)
    /**
     * OrderProductService.
     */
    private final OrderProductService opService;

    /**
     * CheckoutService.
     */
    private final CheckoutService checkoutService;

    /**
     * UserService.
     */
    private final  UserService userService;

    // @checkstyle ParameterNameCheck (80 lines)
    /**
     * Constructor for class WebSecurityConfig.
     * @param opService OrderProductService
     * @param checkoutService CheckoutService
     * @param userService UserService
     */
    @Autowired
    public CheckoutController(
        final OrderProductService opService,
            final CheckoutService checkoutService,
                final UserService userService) {
        this.opService = opService;
        this.checkoutService = checkoutService;
        this.userService = userService;
    }

    /**
     * Method createCheckout.
     * @param user UserDetailsImpl
     * @param model Model
     * @return Checkoutinfo
     */
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @GetMapping("cart/create/checkout")
    @ApiOperation("View order details")
    public String createCheckout(@AuthenticationPrincipal final UserDetailsImpl user,
        final Model model) {
        model.addAttribute("userPage", this.userService.findById(user.getId()));
        model.addAttribute("cartCount", this.opService.cartCount());
        return "checkoutinfo";
    }

    /**
     * Method submit order, clean cart.
     * @param user UserDetailsImpl
     * @param model Model
     * @return Success
     */
    @GetMapping("cart/checkout")
    @ApiOperation("Submit order, clean cart")
    public String checkout(@AuthenticationPrincipal final UserDetailsImpl user,
        final Model model) {
        this.checkoutService.addCheckout();
        model.addAttribute(
            "orderProducts", this.opService
                .findAllByOrder(this.userService
                    .findById(user.getId()).getOrder()
                )
        );
        model.addAttribute(
            "totalOrderPrice", this.opService
                .getTotalPrice(this.opService
                    .findAllByOrder(this.userService
                        .findById(user.getId()).getOrder()
                    )
                )
        );
        this.opService.removeAll();
        model.addAttribute("cartCount", this.opService.cartCount());
        return "success";
    }

    /**
     * Method Error handling.
     * @param request HttpServletRequest
     * @param ex Exception
     * @param model Model
     * @return Error
     */
    @ApiOperation("Error handling")
    @ExceptionHandler(ProductNotFoundException.class)
    public static String handleProductNotFoundException(
        final HttpServletRequest request,
            final ProductNotFoundException ex,
                final Model model) {
        model.addAttribute("exception", ex);
        model.addAttribute("url", request.getRequestURL());
        return "error";
    }
}
