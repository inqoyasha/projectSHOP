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
import org.azamat.model.Product;
import org.azamat.service.CategoryService;
import org.azamat.service.OrderProductService;
import org.azamat.service.ProductService;
import org.azamat.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is HomeController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
@RequestMapping(value = {"", "/", "/home"})
@ApiOperation("/home")
public class HomeController {

    /**
     * ProductService.
     */
    private final ProductService productService;

    /**
     * OrderProductService.
     */
    private final OrderProductService orderProductService;

    /**
     * CategoryService.
     */
    private final CategoryService categoryService;

    /**
     * Constructor for class WebSecurityConfig.
     * @param productService ProductService
     * @param orderProductService OrderProductService
     * @param categoryService CategoryService
     */
    @Autowired
    public HomeController(
        final ProductService productService,
            final OrderProductService orderProductService,
                final CategoryService categoryService) {
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.categoryService = categoryService;
    }

    /**
     * Method return home page.
     * @param user UserDetailsImpl
     * @param model Model
     * @return Home
     */
    @GetMapping
    @ApiOperation("Return home page")
    public String home(@AuthenticationPrincipal final UserDetailsImpl user, final Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        model.addAttribute("cartCount", this.orderProductService.cartCount());
        model.addAttribute("categories", this.categoryService.getAllCategories());
        return "home";
    }

    /**
     * Method return info product page.
     * @param productId ProductId
     * @param model Model
     * @return Info
     */
    @GetMapping("/info/{productId}")
    @ApiOperation("View products")
    public String viewProduct(@PathVariable("productId") final int productId, final Model model) {
        final Product product = this.productService.getProduct(productId).orElse(null);
        model.addAttribute("cartCount", this.orderProductService.cartCount());
        model.addAttribute("product", product);
        return "info";
    }

    /**
     * Method return info product page.
     * @param categoryId CategoryId
     * @param model Model
     * @return Home
     */
    @GetMapping("show/category/{categoryId}")
    @ApiOperation("Getting categories")
    public String viewCategory(@PathVariable("categoryId") final int categoryId,
        final Model model) {
        model.addAttribute(
            "products", this.productService
                .findAllByCategory(this.categoryService
                    .getById(categoryId).orElse(null)
                )
        );
        model.addAttribute("categories", this.categoryService.getAllCategories());
        model.addAttribute("cartCount", this.orderProductService.cartCount());
        return "home";
    }
}
