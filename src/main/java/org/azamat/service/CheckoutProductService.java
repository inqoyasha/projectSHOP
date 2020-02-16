package org.azamat.service;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;

import java.util.List;
import java.util.Optional;

public interface CheckoutProductService {
    CheckoutProduct create(CheckoutProduct checkoutProduct);
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);
    Optional<CheckoutProduct> findById(int id);
    List<CheckoutProduct> findAll();
}
