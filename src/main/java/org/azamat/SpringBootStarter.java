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

package org.azamat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @checkstyle HideUtilityClassConstructor (15 lines)
/**
 * This is SpringBootStarter class.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
public class SpringBootStarter {
    /**
     * Method main.
     * @param args Arguments
     */
    public static void main(final String... args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
