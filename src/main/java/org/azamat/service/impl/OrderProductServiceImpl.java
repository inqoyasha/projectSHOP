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
    /**
     * OrderProductRepository.
     */
    private final OrderProductRepository orderProductRepository;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    /**
     * Constructor for class OrderProductServiceImpl.
     * @param orderProductRepository OrderProductRepository
     * @param session HttpSession
     * @checkstyle ReturnCount (70 lines)
     */
    @Autowired
    public OrderProductServiceImpl(final OrderProductRepository orderProductRepository,
        final HttpSession session) {
        this.orderProductRepository = orderProductRepository;
        this.session = session;
    }

    @Override
    public OrderProduct create(final OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    @Override
    public List<OrderProduct> findAllByOrder(final Order order) {
        return this.orderProductRepository.findByOrder(order);
    }

    @Override
    public void remove(final int id) {
        this.orderProductRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Iterable<OrderProduct> all = this.orderProductRepository.findAll();
        for (final OrderProduct op: all) {
            if (op.getOrder().getId() == userSession.getOrder().getId()) {
                this.remove(op.getId());
            }
        }
    }

    @Override
    public int cartCount() {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        if (userSession == null) {
            return 0;
        }
        final List<OrderProduct> orderProducts = this.findAllByOrder(userSession.getOrder());
        int sum = 0;
        if (orderProducts == null) {
            return 0;
        }
        for (final OrderProduct op: orderProducts) {
            sum += op.getQuantity();
        }
        return sum;
    }

    @Override
    public int getTotalPrice(final List<OrderProduct> orderProducts) {
        int total = 0;
        for (final OrderProduct op : orderProducts) {
            total += op.getSubPrice();
        }
        return total;
    }

    @Override
    public OrderProduct findByOrderAndProduct(final Order order, final Product product) {
        return this.orderProductRepository.findByOrderAndProduct(order, product);
    }
}
