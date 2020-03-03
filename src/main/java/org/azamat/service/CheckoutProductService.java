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

import java.util.List;
import java.util.Optional;
import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;

/**
 * This is Checkout Product Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface CheckoutProductService {
    // @checkstyle ParameterNameCheck (6 lines)
    /**
     * Method create interface method.
     * @param checkoutProduct CheckoutProduct
     * @return CheckoutProduct
     */
    CheckoutProduct create(CheckoutProduct checkoutProduct);

    /**
     * Method findByCheckoutAndProduct interface method.
     * @param checkout Checkout
     * @param product Product
     * @return CheckoutProduct
     */
    CheckoutProduct findByCheckoutAndProduct(Checkout checkout, Product product);

    /**
     * Method findById interface method.
     * @param id CheckoutProduct id
     * @return CheckoutProduct
     */
    Optional<CheckoutProduct> findById(int id);

    // @checkstyle ParameterNameCheck (6 lines)
    /**
     * Method getTotalPrice interface method.
     * @param checkoutProducts List of CheckoutProducts
     * @return TotalPrice
     */
    int getTotalPrice(List<CheckoutProduct> checkoutProducts);

    /**
     * Method findAll interface method.
     * @return List of CheckoutProducts
     */
    List<CheckoutProduct> findAll();

    /**
     * Method getAllByCheckout interface method.
     * @param id Checkout id
     * @return CheckoutProduct
     */
    List<CheckoutProduct> getAllByCheckout(int id);
}
