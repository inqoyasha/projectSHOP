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

import org.azamat.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is Category Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
