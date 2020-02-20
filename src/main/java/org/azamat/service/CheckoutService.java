package org.azamat.service;

import org.azamat.model.Checkout;

import java.util.Collection;
import java.util.Optional;

public interface CheckoutService {
    Checkout create(Checkout checkout);
    Optional<Checkout> getById(int id);
    Collection<Checkout> getAllByUser(long id);
    void addCheckout();
}
