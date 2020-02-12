package org.azamat.repository;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutProductRepository extends JpaRepository<CheckoutProduct, Integer> {
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);
}
