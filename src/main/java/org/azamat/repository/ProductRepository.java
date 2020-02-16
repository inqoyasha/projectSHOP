package org.azamat.repository;

import org.azamat.model.Category;
import org.azamat.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByCategory(Category category);
}
