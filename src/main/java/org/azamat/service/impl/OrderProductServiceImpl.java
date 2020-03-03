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
import javax.servlet.http.HttpSession;
import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.OrderProductRepository;
import org.azamat.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is Order Product Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class OrderProductServiceImpl implements OrderProductService {
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * OrderProductRepository.
     */
    private final OrderProductRepository opRepository;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    // @checkstyle ParameterNameCheck (7 lines)
    /**
     * Constructor for class OrderProductServiceImpl.
     * @param opRepository OrderProductRepository
     * @param session HttpSession
     */
    @Autowired
    public OrderProductServiceImpl(final OrderProductRepository opRepository,
        final HttpSession session) {
        this.opRepository = opRepository;
        this.session = session;
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    // @checkstyle ParameterNameCheck (2 lines)
    @Override
    public OrderProduct create(final OrderProduct orderProduct) {
        return this.opRepository.save(orderProduct);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public List<OrderProduct> findAllByOrder(final Order order) {
        return this.opRepository.findByOrder(order);
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public void remove(final int id) {
        this.opRepository.deleteById(id);
    }

    // @checkstyle DesignForExtensionCheck (4 lines)
    // @checkstyle LocalFinalVariableNameCheck (6 lines)
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @Override
    public void removeAll() {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Iterable<OrderProduct> all = this.opRepository.findAll();
        for (final OrderProduct op: all) {
            if (op.getOrder().getId() == userSession.getOrder().getId()) {
                this.remove(op.getId());
            }
        }
    }

    // @checkstyle DesignForExtensionCheck (5 lines)
    // @checkstyle LocalFinalVariableNameCheck (14 lines)
    // @checkstyle ReturnCount (17 lines)
    @SuppressWarnings("PMD.OnlyOneReturn")
    @Override
    public int cartCount() {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        if (userSession == null) {
            return 0;
        }
        final List<OrderProduct> orderProducts = this.findAllByOrder(userSession.getOrder());
        if (orderProducts == null) {
            return 0;
        }
        int sum = 0;
        for (final OrderProduct op: orderProducts) {
            sum += op.getQuantity();
        }
        return sum;
    }

    // @checkstyle DesignForExtensionCheck (4 lines)
    // @checkstyle LocalFinalVariableNameCheck (5 lines)
    // @checkstyle ParameterNameCheck (2 lines)
    @Override
    public int getTotalPrice(final List<OrderProduct> orderProducts) {
        int total = 0;
        for (final OrderProduct op : orderProducts) {
            total += op.getSubPrice();
        }
        return total;
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public OrderProduct findByOrderAndProduct(final Order order, final Product product) {
        return this.opRepository.findByOrderAndProduct(order, product);
    }
}
