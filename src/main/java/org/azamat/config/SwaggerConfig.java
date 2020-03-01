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
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is SwaggerConfig class for generate api.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Method api generate.
     * @return New Docket object
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.apiInfo());
    }

    /**
     * Method apiInfo generate.
     * @return New ApiInfoBuilder object
     */
    private static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Swagger API e-shop")
            .description("This is a documentation for e-shop api")
            .version("0.0.1")
            .build();
    }

}
