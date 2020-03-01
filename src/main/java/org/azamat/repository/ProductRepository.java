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

package org.azamat.repository;

import java.util.List;
import org.azamat.model.Category;
import org.azamat.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * This is Product Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {
    /**
     * Method findByCategory interface method.
     * @param category Category
     * @return List of Products
     */
    List<Product> findByCategory(Category category);
}
