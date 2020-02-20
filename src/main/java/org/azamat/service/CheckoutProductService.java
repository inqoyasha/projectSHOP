package org.azamat.service;

import org.azamat.model.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CheckoutProductService {
    CheckoutProduct create(CheckoutProduct checkoutProduct);
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);
    Optional<CheckoutProduct> findById(int id);
    int getTotalPrice(List<CheckoutProduct> checkoutProducts);
    List<CheckoutProduct> findAll();
    List<CheckoutProduct> getAllByCheckout(int id);
}
