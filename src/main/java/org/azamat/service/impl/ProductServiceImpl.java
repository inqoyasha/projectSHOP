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

package org.azamat.service.impl;

import java.util.List;
import java.util.Optional;
import org.azamat.model.Category;
import org.azamat.model.Product;
import org.azamat.repository.ProductRepository;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is Product Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class ProductServiceImpl implements ProductService {
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * ProductRepository.
     */
    private final ProductRepository productRepository;

    // @checkstyle ParameterNameCheck (6 lines)
    /**
     * Constructor for class ProductServiceImpl.
     * @param productRepository ProductRepository
     */
    @Autowired
    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Iterable<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    // @checkstyle ParameterNameCheck (2 lines)
    @Override
    public Optional<Product> getProduct(final Integer productId) {
        return this.productRepository.findById(productId);
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    // @checkstyle LocalFinalVariableNameCheck (3 lines)
    @Override
    public void update(final Product product, final int id) {
        final Product productFromDB = this.productRepository.findById(id).orElse(null);
        productFromDB.setPictureUrl(product.getPictureUrl());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setProductName(product.getProductName());
        productFromDB.setQuantity(product.getQuantity());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setCategory(product.getCategory());
        productFromDB.setManufacturer(product.getManufacturer());
        this.productRepository.save(productFromDB);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public List<Product> findAllByCategory(final Category category) {
        return this.productRepository.findByCategory(category);
    }
}
