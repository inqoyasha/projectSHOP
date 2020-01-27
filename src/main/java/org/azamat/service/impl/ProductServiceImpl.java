package org.azamat.service.impl;

import org.azamat.model.Product;
import org.azamat.repository.ProductRepository;
import org.azamat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @Override
    public Optional<Product> getProduct(Integer p_id) {
        return productRepository.findById(p_id);
    }
}
