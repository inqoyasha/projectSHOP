package org.azamat.repository;

import org.azamat.model.Product;
import org.azamat.projections.ProductId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
