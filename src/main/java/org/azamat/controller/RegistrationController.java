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
import org.azamat.model.securitymodel.User;
import org.azamat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This is RegistrationController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
public class RegistrationController {

    /**
     * UserService.
     */
    private final UserService userService;

    /**
     * Constructor for class WebSecurityConfig.
     * @param userService UserService
     */
    @Autowired
    public RegistrationController(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Method return registration page.
     * @param model Model
     * @return Registration
     */
    @GetMapping("/registration")
    @ApiOperation("View registration form")
    public static String registration(final Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    /**
     * Method return home page.
     * @param user User
     * @param model Model
     * @return Login
     * @checkstyle ReturnCount (13 lines)
     */
    @PostMapping("/registration")
    @ApiOperation("Register new user")
    public String addUser(@ModelAttribute("userForm") final User user, final Model model) {
        final User userDB = this.userService.findByUsername(user.getUsername());
        if (userDB != null) {
            model.addAttribute(
                "message", "Username already in use, try a different one."
            );
            return "registration";
        }
        this.userService.registerUser(user);
        return "redirect:/login";
    }
}
