package org.azamat.service;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;

import java.util.List;

public interface CheckoutProductService {
    CheckoutProduct create(CheckoutProduct checkoutProduct);
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);
    List<CheckoutProduct> findAll();
}
