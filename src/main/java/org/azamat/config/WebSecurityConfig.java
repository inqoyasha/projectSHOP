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

package org.azamat.config;

import org.azamat.component.AuthenticationSuccessHandlerImpl;
import org.azamat.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This is WebSecurityConfig class for configure spring security.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Configuration
@EnableWebSecurity
public class  WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * UserService.
     */
    private final UserDetailsServiceImpl userService;

    /**
     * AuthenticationSuccessHandler.
     */
    private final AuthenticationSuccessHandlerImpl auth;

    // @checkstyle ParameterNameCheck (12 lines)
    /**
     * Constructor for class WebSecurityConfig.
     * @param userService UserService
     * @param auth AuthenticationSuccessHandlerImpl
     */
    @Autowired
    public WebSecurityConfig(
        final UserDetailsServiceImpl userService,
            final AuthenticationSuccessHandlerImpl auth) {
        this.userService = userService;
        this.auth = auth;
    }

    /**
     * Method api generate.
     * @return New BCryptPasswordEncoder object
     */
    @SuppressWarnings("PMD.ProhibitPublicStaticMethods")
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        final String user = "USER";
        final String admin = "ADMIN";
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(
        "/", "/registration", "/info/**", "/show/**", "/js/**", "/images/**", "/css/**"
            ).permitAll()
                .antMatchers(
        "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
            "/configuration/**", "/swagger-ui.html#/**", "/swagger-ui.html"
            ).permitAll()
                .antMatchers("/cart/**", "/account").hasRole(user)
                .antMatchers("/manage/**", "/admin/**").hasRole(admin)
                .antMatchers("/logout ").hasAnyRole(admin, user)
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(this.auth)
                .permitAll()
            .and()
                .logout()
                .permitAll();
    }

    @Override
    // @checkstyle HiddenField (4 lines)
    protected final void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService)
            .passwordEncoder(this.passwordEncoder());
    }
}
