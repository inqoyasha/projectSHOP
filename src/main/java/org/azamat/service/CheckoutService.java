/*
 * Copyright (c) 2019-2020, Aamat.org
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 *
 * modification, are permitted provided that the following conditions
 *
 * are met: no conditions.
 */

package org.azamat.service;

import java.util.Collection;
import java.util.Optional;
import org.azamat.model.Checkout;

/**
 * This is Checkout Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface CheckoutService {
    /**
     * Method create interface method.
     * @param checkout Checkout
     * @return Checkout
     */
    Checkout create(Checkout checkout);

    /**
     * Method getById interface method.
     * @param id Checkout id
     * @return Checkout
     */
    Optional<Checkout> getById(int id);

    /**
     * Method getAllByUser interface method.
     * @param id User id
     * @return List of Checkouts
     */
    Collection<Checkout> getAllByUser(long id);

    /**
     * Method addCheckout interface method.
     */
    void addCheckout();
}
