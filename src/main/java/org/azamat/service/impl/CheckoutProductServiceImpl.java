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
    // @checkstyle MemberNameCheck (5 lines)
    /**
     * CheckoutRepository.
     */
    private final CheckoutRepository checkoutRepo;

    // @checkstyle MemberNameCheck (5 lines)
    /**
     * CheckoutProductRepository.
     */
    private final CheckoutProductRepository checkPRepository;

    // @checkstyle ParameterNameCheck (8 lines)
    /**
     * Constructor for class CategoryServiceImpl.
     * @param checkoutRepo CheckoutRepository
     * @param checkPRepository CheckoutProductRepository
     */
    @Autowired
    public CheckoutProductServiceImpl(final CheckoutRepository checkoutRepo,
        final CheckoutProductRepository checkPRepository) {
        this.checkoutRepo = checkoutRepo;
        this.checkPRepository = checkPRepository;
    }

    // @checkstyle ParameterNameCheck (3 lines)
    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public CheckoutProduct create(final CheckoutProduct checkoutProduct) {
        return this.checkPRepository.save(checkoutProduct);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public CheckoutProduct findByCheckoutAndProduct(final Checkout checkout,
        final Product product) {
        return this.checkPRepository.findByCheckoutAndProduct(checkout, product);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Optional<CheckoutProduct> findById(final int id) {
        return this.checkPRepository.findById(id);
    }

    // @checkstyle LocalFinalVariableNameCheck (6 lines)
    // @checkstyle ParameterNameCheck (3 lines)
    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public int getTotalPrice(final List<CheckoutProduct> checkoutProducts) {
        int total = 0;
        for (final CheckoutProduct op : checkoutProducts) {
            total += op.getSubPrice();
        }
        return total;
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public List<CheckoutProduct> findAll() {
        return this.checkPRepository.findAll();
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public List<CheckoutProduct> getAllByCheckout(final int id) {
        final Checkout checkout = this.checkoutRepo.findById(id).orElse(new Checkout());
        return this.checkPRepository.findByCheckout(checkout);
    }

}
