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
import org.azamat.model.securitymodel.User;
import org.azamat.service.CheckoutProductService;
import org.azamat.service.OrderProductService;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This is UserPageController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
public class UserPageController {

    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootStarter.class);

    // @checkstyle MemberNameCheck (15 lines)
    /**
     * UserService.
     */
    private final UserService userService;

    /**
     * CheckoutProductService.
     */
    private final CheckoutProductService cpService;

    /**
     * CheckoutProductService.
     */
    private final OrderProductService opService;

    // @checkstyle ParameterNameCheck (11 lines)
    /**
     * Constructor for class WebSecurityConfig.
     * @param userService UserService
     * @param cpService CheckoutProductService
     * @param opService OrderProductService
     */
    @Autowired
    public UserPageController(
        final UserService userService,
            final CheckoutProductService cpService,
                final OrderProductService opService) {
        this.userService = userService;
        this.cpService = cpService;
        this.opService = opService;
    }

    /**
     * Method show user page.
     * @param user UserDetailsImpl
     * @param model Model
     * @return Userpage
     */
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @GetMapping("/account")
    @ApiOperation("View user page")
    public String account(@AuthenticationPrincipal final UserDetailsImpl user, final Model model) {
        model.addAttribute("userPage", this.userService.findById(user.getId()));
        model.addAttribute("orders", this.cpService.findAll());
        model.addAttribute("cartCount", this.opService.cartCount());
        return "userpage";
    }

    // @checkstyle LocalFinalVariableNameCheck (11 lines)
    /**
     * Method show user page.
     * @param user User
     * @param model Model
     * @return Userpage
     */
    @PostMapping("/account")
    @ApiOperation("Edit user data")
    public String saveData(@ModelAttribute final User user,
        final Model model) {
        final User newUser = new User(
            user.getFirstName(),
            user.getLastName(),
            user.getPatronymic(),
            user.getEmail(),
            user.getAddress()
        );
        this.userService.update(newUser);
        LOGGER.debug("Edit user data {}", newUser);
        model.addAttribute("userPage", newUser);
        return "userpage";
    }
}

