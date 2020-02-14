package org.azamat.service;

import org.azamat.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> getById(int id);
    Category create(Category category);
}
