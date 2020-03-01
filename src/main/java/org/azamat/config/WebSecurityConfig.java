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

    /**
     * UserService.
     */
    private final UserDetailsServiceImpl userService;

    /**
     * AuthenticationSuccessHandler.
     */
    private final AuthenticationSuccessHandlerImpl authenticationSuccessHandler;

    /**
     * Constructor for class WebSecurityConfig.
     * @param userService UserService
     * @param authenticationSuccessHandler AuthenticationSuccessHandlerImpl
     */
    @Autowired
    public WebSecurityConfig(
        final UserDetailsServiceImpl userService,
            final AuthenticationSuccessHandlerImpl authenticationSuccessHandler) {
        this.userService = userService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    /**
     * Method api generate.
     * @return New BCryptPasswordEncoder object
     */
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(
        "/", "/registration", "/info/**", "/show/**", "/js/**", "/images/**", "/css/**"
            ).permitAll()
                .antMatchers(
        "/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
            "/configuration/**", "/swagger-ui.html#/**", "/swagger-ui.html"
            ).permitAll()
                .antMatchers("/cart/**", "/account").hasRole("USER")
                .antMatchers("/manage/**", "/admin/**").hasRole("ADMIN")
                .antMatchers("/logout ").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(this.authenticationSuccessHandler)
                .permitAll()
            .and()
                .logout()
                .permitAll();
    }

    @Override
    protected final void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService)
            .passwordEncoder(this.passwordEncoder());
    }

}
