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

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.azamat.exception.ProductNotFoundException;
import org.azamat.model.Checkout;
import org.azamat.model.CheckoutProduct;
import org.azamat.model.CheckoutStatus;
import org.azamat.model.OrderProduct;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.CheckoutProductRepository;
import org.azamat.repository.CheckoutRepository;
import org.azamat.repository.OrderProductRepository;
import org.azamat.repository.UserRepository;
import org.azamat.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is Checkout Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    /**
     * CheckoutRepository.
     */
    private final CheckoutRepository checkoutRepository;

    /**
     * CheckoutProductRepository.
     */
    private final CheckoutProductRepository checkoutProductRepository;

    /**
     * UserRepository.
     */
    private final UserRepository userRepository;

    /**
     * OrderProductRepository.
     */
    private final OrderProductRepository orderProductRepository;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    /**
     * Constructor for class CheckoutServiceImpl.
     * @param checkoutRepository CheckoutRepository
     * @param checkoutProductRepository CheckoutProductRepository
     * @param userRepository UserRepository
     * @param orderProductRepository OrderProductRepository
     * @param session HttpSession
     * @checkstyle ParameterNumber (7 lines)
     */
    @Autowired
    public CheckoutServiceImpl(final CheckoutRepository checkoutRepository,
        final CheckoutProductRepository checkoutProductRepository,
            final UserRepository userRepository,
                final OrderProductRepository orderProductRepository,
                    final HttpSession session) {
        this.checkoutRepository = checkoutRepository;
        this.checkoutProductRepository = checkoutProductRepository;
        this.userRepository = userRepository;
        this.orderProductRepository = orderProductRepository;
        this.session = session;
    }

    @Override
    public Checkout create(final Checkout checkout) {
        return this.checkoutRepository.save(checkout);
    }

    @Override
    public Optional<Checkout> getById(final int id) {
        return this.checkoutRepository.findById(id);
    }

    @Override
    public Collection<Checkout> getAllByUser(final long id) {
        final User user = this.userRepository.findById(id).orElse(null);
        return this.checkoutRepository.findByUser(user);
    }

    @Override
    public void addCheckout() {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Checkout checkout = new Checkout();
        this.checkoutRepository.save(checkout);
        checkout.setUser(userSession);
        checkout.setName(new StringBuilder("new order").append(checkout.getId()).toString());
        checkout.setStatus(CheckoutStatus.SENT_TO_SELLER);
        checkout.setDateCreated(LocalDateTime.now());
        this.checkoutRepository.save(checkout);
        for (final OrderProduct op: this.orderProductRepository.findAll()) {
            if (op.getOrder().getId().equals(userSession.getOrder().getId())) {
                final CheckoutProduct checkoutProduct = new CheckoutProduct();
                checkoutProduct.setCheckout(checkout);
                checkoutProduct.setProduct(op.getProduct());
                checkoutProduct.setQuantity(op.getQuantity());
                checkoutProduct.setSubPrice(op.getSubPrice());
                this.checkoutProductRepository.save(checkoutProduct);
                if (op.getProduct().getQuantity() - op.getQuantity() < 0) {
                    throw new ProductNotFoundException(
                        op.getProduct().getId(), op.getProduct().getQuantity()
                    );
                } else {
                    op.getProduct().setQuantity(op.getProduct().getQuantity() - op.getQuantity());
                }
            }
        }
    }
}
