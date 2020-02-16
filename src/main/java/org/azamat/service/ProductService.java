package org.azamat.service;

import org.azamat.model.Category;
import org.azamat.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Optional<Product> getProduct(Integer p_id);
    void update(Product product, int id);
    List<Product> findAllByCategory(Category category);
}
