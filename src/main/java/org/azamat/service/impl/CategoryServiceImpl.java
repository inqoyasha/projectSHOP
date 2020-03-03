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
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * CategoryRepository.
     */
    private final CategoryRepository categoryRepo;

    // @checkstyle ParameterNameCheck (6 lines)
    /**
     * Constructor for class CategoryServiceImpl.
     * @param categoryRepo CategoryRepository
     */
    @Autowired
    public CategoryServiceImpl(final CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Iterable<Category> getAllCategories() {
        return this.categoryRepo.findAll();
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    // @checkstyle ParameterNameCheck (2 lines)
    @Override
    public Optional<Category> getById(final Integer categoryId) {
        return this.categoryRepo.findById(categoryId);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Category create(final Category category) {
        return this.categoryRepo.save(category);
    }
}
