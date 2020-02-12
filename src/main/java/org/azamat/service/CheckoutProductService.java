package org.azamat.service;

import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;

public interface CheckoutProductService {
    CheckoutProduct create(CheckoutProduct checkoutProduct);
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);
}
