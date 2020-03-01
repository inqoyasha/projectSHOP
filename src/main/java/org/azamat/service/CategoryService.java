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

import java.util.Optional;
import org.azamat.model.Category;

/**
 * This is Category Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface CategoryService {
    /**
     * Method getAllCategories interface method.
     * @return Category
     */
    Iterable<Category> getAllCategories();

    /**
     * Method getById interface method.
     * @param categoryId Category id
     * @return Category
     */
    Optional<Category> getById(Integer categoryId);

    /**
     * Method create interface method.
     * @param category Category
     * @return Category
     */
    Category create(Category category);
}
