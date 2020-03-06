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
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * CheckoutRepository.
     */
    private final CheckoutRepository checkoutRepo;

    // @checkstyle MemberNameCheck (4 lines)
    /**
     * CheckoutProductRepository.
     */
    private final CheckoutProductRepository checkPRepository;

    // @checkstyle MemberNameCheck (4 lines)
    /**
     * UserRepository.
     */
    private final UserRepository userRepository;

    // @checkstyle MemberNameCheck (4 lines)
    /**
     * OrderProductRepository.
     */
    private final OrderProductRepository opRepository;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    // @checkstyle ParameterNameCheck (14 lines)
    // @checkstyle ParameterNumber (15 lines)
    /**
     * Constructor for class CheckoutServiceImpl.
     * @param checkoutRepo CheckoutRepository
     * @param checkPRepository CheckoutProductRepository
     * @param userRepository UserRepository
     * @param opRepository OrderProductRepository
     * @param session HttpSession
     */
    @Autowired
    public CheckoutServiceImpl(final CheckoutRepository checkoutRepo,
        final CheckoutProductRepository checkPRepository,
            final UserRepository userRepository,
                final OrderProductRepository opRepository,
                    final HttpSession session) {
        this.checkoutRepo = checkoutRepo;
        this.checkPRepository = checkPRepository;
        this.userRepository = userRepository;
        this.opRepository = opRepository;
        this.session = session;
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Checkout create(final Checkout checkout) {
        return this.checkoutRepo.save(checkout);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Optional<Checkout> getById(final int id) {
        return this.checkoutRepo.findById(id);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Collection<Checkout> getAllByUser(final long id) {
        final User user = this.userRepository.findById(id).orElse(null);
        return this.checkoutRepo.findByUser(user);
    }

    // @checkstyle LocalFinalVariableNameCheck (16 lines)
    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public void addCheckout() {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Checkout checkout = new Checkout();
        this.checkoutRepo.save(checkout);
        checkout.setUser(userSession);
        checkout.setName(new StringBuilder("new order").append(checkout.getId()).toString());
        checkout.setStatus(CheckoutStatus.SENT_TO_SELLER);
        checkout.setDateCreated(LocalDateTime.now());
        this.checkoutRepo.save(checkout);
        for (final OrderProduct op: this.opRepository.findAll()) {
            if (!(op.getOrder().getId().equals(userSession.getOrder().getId()))) {
                continue;
            }
            final CheckoutProduct checkoutProduct = new CheckoutProduct();
            checkoutProduct.setCheckout(checkout);
            checkoutProduct.setProduct(op.getProduct());
            checkoutProduct.setQuantity(op.getQuantity());
            checkoutProduct.setSubPrice(op.getSubPrice());
            this.checkPRepository.save(checkoutProduct);
            if (op.getProduct().getQuantity() - op.getQuantity() < 0) {
                throw new ProductNotFoundException(
                    op.getProduct().getId(), op.getProduct().getQuantity()
                );
            }
            op.getProduct().setQuantity(op.getProduct().getQuantity() - op.getQuantity());
        }
    }
}
