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

package org.azamat.service.impl;

import java.util.List;
import java.util.Optional;
import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.Product;
import org.azamat.repository.CheckoutProductRepository;
import org.azamat.repository.CheckoutRepository;
import org.azamat.service.CheckoutProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is Checkout Product Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class CheckoutProductServiceImpl implements CheckoutProductService {
    /**
     * CheckoutRepository.
     */
    private final CheckoutRepository checkoutRepository;

    /**
     * CheckoutProductRepository.
     */
    private final CheckoutProductRepository checkoutProductRepository;

    /**
     * Constructor for class CategoryServiceImpl.
     * @param checkoutRepository CheckoutRepository
     * @param checkoutProductRepository CheckoutProductRepository
     */
    @Autowired
    public CheckoutProductServiceImpl(final CheckoutRepository checkoutRepository,
        final CheckoutProductRepository checkoutProductRepository) {
        this.checkoutRepository = checkoutRepository;
        this.checkoutProductRepository = checkoutProductRepository;
    }

    @Override
    public CheckoutProduct create(final CheckoutProduct checkoutProduct) {
        return this.checkoutProductRepository.save(checkoutProduct);
    }

    @Override
    public CheckoutProduct findByCheckoutAndProduct(final Checkout checkout, final Product product) {
        return this.checkoutProductRepository.findByCheckoutAndProduct(checkout, product);
    }

    @Override
    public Optional<CheckoutProduct> findById(final int id) {
        return this.checkoutProductRepository.findById(id);
    }

    @Override
    public int getTotalPrice(final List<CheckoutProduct> checkoutProducts) {
        int total = 0;
        for (CheckoutProduct op : checkoutProducts) {
            total += op.getSubPrice();
        }
        return total;
    }

    @Override
    public List<CheckoutProduct> findAll() {
        return this.checkoutProductRepository.findAll();
    }

    @Override
    public List<CheckoutProduct> getAllByCheckout(final int id) {
        Checkout checkout = this.checkoutRepository.findById(id).orElse(new Checkout());
        return this.checkoutProductRepository.findByCheckout(checkout);
    }

}
