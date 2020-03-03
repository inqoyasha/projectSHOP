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
import org.azamat.SpringBootStarter;
import org.azamat.service.OrderProductService;
import org.azamat.service.OrderService;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is OrderController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
@RequestMapping("/cart")
@ApiOperation("/cart")
public class OrderController {

    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootStarter.class);

    // @checkstyle MemberNameCheck (15 lines)
    /**
     * OrderService.
     */
    private final OrderService orderService;

    /**
     * OrderProductService.
     */
    private final OrderProductService opService;

    /**
     * UserService.
     */
    private final  UserService userService;

    // @checkstyle ParameterNameCheck (75 lines)
    /**
     * Constructor for class WebSecurityConfig.
     * @param orderService OrderService
     * @param opService OrderProductService
     * @param userService UserService
     */
    @Autowired
    public OrderController(
        final OrderService orderService,
            final OrderProductService opService,
                final UserService userService) {
        this.orderService = orderService;
        this.opService = opService;
        this.userService = userService;
    }

    /**
     * Method view cart.
     * @param user UserDetailsImpl
     * @param model Model
     * @return Order
     */
    @GetMapping
    @ApiOperation("View cart")
    public String cart(@AuthenticationPrincipal final UserDetailsImpl user, final Model model) {
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
        model.addAttribute("cartCount", this.opService.cartCount());
        return "order";
    }

    /**
     * Method return info product page.
     * @param productId ProductId
     * @return Cart
     */
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @GetMapping("/buy/{productId}")
    @ApiOperation("Add new product in cart by id")
    public String buy(@PathVariable("productId") final Integer productId) {
        this.orderService.addOrderProduct(productId);
        LOGGER.debug("Add product in cart with id {}", productId);
        return "redirect:/cart";
    }

    /**
     * Method return info product page.
     * @param productId ProductId
     * @return Cart
     */
    @GetMapping("/remove/{productId}")
    @ApiOperation("Remove product from cart by id")
    public String remove(@PathVariable("productId") final Integer productId) {
        this.orderService.removeOrderProduct(productId);
        LOGGER.debug("Remove product from cart with id {}", productId);
        return "redirect:/cart";
    }
}
