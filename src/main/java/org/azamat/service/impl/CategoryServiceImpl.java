package org.azamat.service.impl;

import org.azamat.model.Category;
import org.azamat.repository.CategoryRepository;
import org.azamat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(Integer c_id) {
        return this.categoryRepository.findById(c_id);
    }

    @Override
    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }
}
