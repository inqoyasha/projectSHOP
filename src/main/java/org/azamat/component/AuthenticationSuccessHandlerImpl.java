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

package org.azamat.component;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.azamat.SpringBootStarter;
import org.azamat.service.UserService;
import org.azamat.service.impl.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * This is authentication success handler.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootStarter.class);

    /**
     * UserService.
     */
    private final UserService userService;

    /**
     * Constructor for class AuthenticationSuccessHandlerImpl.
     * @param userService UserService
     */
    @Autowired
    public AuthenticationSuccessHandlerImpl(@Lazy final UserService userService) {
        this.userService = userService;
    }

    @Override
    public final void onAuthenticationSuccess(
        final HttpServletRequest request,
            final HttpServletResponse response,
                final Authentication authentication) throws IOException, ServletException {
        final HttpSession session = request.getSession(true);
        final UserDetailsImpl authUser =
            (UserDetailsImpl) SecurityContextHolder.getContext()
                .getAuthentication()
                    .getPrincipal();
        final String userName = authUser.getUsername();
        session.setAttribute("role", String.valueOf(authUser.getAuthorities()));
        session.setAttribute("connectedUser", this.userService.findByUsername(userName));
        LOGGER.info("userName: {}", userName);
        LOGGER.debug("connected user with username: {}", userName);
        session.setAttribute("userName ", userName);
        response.sendRedirect("/home");
    }
}
