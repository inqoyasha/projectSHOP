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
import org.azamat.service.CheckoutProductService;
import org.azamat.service.CheckoutService;
import org.azamat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is UserOrdersController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
@RequestMapping("/admin")
@ApiOperation("/admin")
public class UserOrdersController {

    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootStarter.class);

    /**
     * CheckoutService.
     */
    private final CheckoutService checkoutService;

    /**
     * CheckoutProductService.
     */
    private final CheckoutProductService checkoutProductService;

    /**
     * UserService.
     */
    private final UserService userService;

    /**
     * Constructor for class WebSecurityConfig.
     * @param checkoutService CheckoutService
     * @param checkoutProductService CheckoutProductService
     * @param userService UserService
     */
    @Autowired
    public UserOrdersController(
        final CheckoutService checkoutService,
            final CheckoutProductService checkoutProductService,
                final UserService userService) {
        this.checkoutService = checkoutService;
        this.checkoutProductService = checkoutProductService;
        this.userService = userService;
    }

    /**
     * Method show lisst of users.
     * @param model Model
     * @return Users
     */
    @GetMapping("/users")
    @ApiOperation("Show list of users")
    public String viewUsers(final Model model) {
        model.addAttribute("users", this.userService.getAll());
        return "users";
    }

    /**
     * Method show user orders by user id.
     * @param id UserOrderId
     * @param model Model
     * @return Userorders
     */
    @GetMapping("/user-orders/{id}")
    @ApiOperation("Show user orders by user id")
    public String viewOrders(@PathVariable("id") final int id,
        final Model model) {
        model.addAttribute("orders", this.checkoutService.getAllByUser(id));
        LOGGER.debug("Show user orders by user id {}", id);
        return "userorders";
    }

    /**
     * Method show order details by order id.
     * @param id UserOrderId
     * @param model Model
     * @return Userorderinfo
     */
    @GetMapping("/user-orders/{id}/info")
    @ApiOperation("Show order details by order id")
    public String viewOrderInfo(@PathVariable("id") final int id,
        final Model model) {
        model.addAttribute("orderDetails", this.checkoutProductService.getAllByCheckout(id));
        model.addAttribute(
            "totalOrderPrice", this.checkoutProductService
                .getTotalPrice(this.checkoutProductService.getAllByCheckout(id))
        );
        return "userorderinfo";
    }
}
