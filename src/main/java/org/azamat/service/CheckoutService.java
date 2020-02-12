package org.azamat.service;

import org.azamat.model.Checkout;

public interface CheckoutService {
    Checkout create(Checkout checkout);

    void addCheckout();
}
