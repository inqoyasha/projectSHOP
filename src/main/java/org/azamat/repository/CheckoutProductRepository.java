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

package org.azamat.repository;

import java.util.List;
import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is Checkout Product Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface CheckoutProductRepository extends JpaRepository<CheckoutProduct, Integer> {
    /**
     * Method findByCheckoutAndProduct interface method.
     * @param checkout Checkout
     * @param product Product
     * @return CheckoutProduct
     */
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);

    /**
     * Method findByCheckout interface method.
     * @param checkout Checkout
     * @return List of CheckoutProducts
     */
    List<CheckoutProduct> findByCheckout(Checkout checkout);
}
