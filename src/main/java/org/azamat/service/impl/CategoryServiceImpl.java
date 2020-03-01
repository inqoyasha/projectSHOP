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

import java.util.Optional;
import org.azamat.model.Category;
import org.azamat.repository.CategoryRepository;
import org.azamat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is Category Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    /**
     * CategoryRepository.
     */
    private final CategoryRepository categoryRepository;

    /**
     * Constructor for class CategoryServiceImpl.
     * @param categoryRepository CategoryRepository
     */
    @Autowired
    public CategoryServiceImpl(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(final Integer categoryId) {
        return this.categoryRepository.findById(categoryId);
    }

    @Override
    public Category create(final Category category) {
        return this.categoryRepository.save(category);
    }
}
