package org.azamat.service;

import org.azamat.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Optional<Product> getProduct(Integer p_id);
}
