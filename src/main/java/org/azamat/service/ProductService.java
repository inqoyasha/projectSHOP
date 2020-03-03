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

package org.azamat.service;

import java.util.List;
import java.util.Optional;
import org.azamat.model.Category;
import org.azamat.model.Product;

/**
 * This is Product Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface ProductService {
    /**
     * Method getAllProducts interface method.
     * @return List of Products
     */
    Iterable<Product> getAllProducts();

    // @checkstyle ParameterNameCheck (6 lines)
    /**
     * Method getProduct interface method.
     * @param productId Product id
     * @return Product
     */
    Optional<Product> getProduct(Integer productId);

    /**
     * Method update interface method.
     * @param product Product
     * @param id Product id
     */
    void update(Product product, int id);

    /**
     * Method findAllByCategory interface method.
     * @param category Category
     * @return List of Products
     */
    List<Product> findAllByCategory(Category category);
}
