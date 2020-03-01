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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * This is MvcConfig class for configure MVC.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public final void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * Method view resolver.
     * @return View resolver
     */
    @Bean
    static UrlBasedViewResolver viewResolver() {
        final UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
