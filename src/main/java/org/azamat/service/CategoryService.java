package org.azamat.service;

import org.azamat.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Iterable<Category> getAllCategories();
    Optional<Category> getById(Integer c_id);
    Category create(Category category);
}
