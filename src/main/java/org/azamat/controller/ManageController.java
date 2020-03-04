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
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is ManageController.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Controller
@RequestMapping("/manage")
@ApiOperation("/manage")
public class ManageController {
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * ProductService.
     */
    private final ProductService productService;

    // @checkstyle ParameterNameCheck (60 lines)
    /**
     * Constructor for class WebSecurityConfig.
     * @param productService ProductService
     */
    @Autowired
    public ManageController(final ProductService productService) {
        this.productService = productService;
    }

    /**
     * Method view all products.
     * @param model Model
     * @return Manage
     */
    @GetMapping("/show/all")
    @ApiOperation("View all products")
    public String viewProduct(final Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "manage";
    }

    /**
     * Method return edit product page.
     * @param productId ProductId
     * @param model Model
     * @return Editproduct
     */
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @GetMapping("/edit/{productId}")
    @ApiOperation("View product by id")
    public String editProduct(@PathVariable("productId") final int productId, final Model model) {
        final Product product = this.productService.getProduct(productId).orElse(new Product());
        model.addAttribute("product", product);
        return "editproduct";
    }

    // @checkstyle LocalFinalVariableNameCheck (20 lines)
    /**
     * Method return edit product page by id.
     * @param productId ProductId
     * @param product Product
     * @param model Model
     * @return Editproduct
     */
    @PostMapping("/edit/{productId}")
    @ApiOperation("Edit product by id")
    public String saveEditProduct(
        @PathVariable("productId") final int productId,
            @ModelAttribute("product") final Product product,
                final Model model) {
        final Product newProduct = new Product(
            product.getProductName(),
            product.getDescription(),
            product.getManufacturer(),
            product.getPictureUrl(),
            product.getPrice(),
            product.getQuantity(),
            product.getCategory()
        );
        this.productService.update(newProduct, productId);
        model.addAttribute("product", newProduct);
        return "editproduct";
    }
}
