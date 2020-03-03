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

import javax.servlet.http.HttpSession;
import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.OrderProductRepository;
import org.azamat.repository.OrderRepository;
import org.azamat.repository.ProductRepository;
import org.azamat.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is Order Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class OrderServiceImpl implements OrderService {
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * OrderRepository.
     */
    private final OrderRepository orderRepository;

    // @checkstyle MemberNameCheck (4 lines)
    /**
     * OrderProductRepository.
     */
    private final OrderProductRepository opRepository;

    // @checkstyle MemberNameCheck (4 lines)
    /**
     * ProductRepository.
     */
    private final ProductRepository productRepository;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    // @checkstyle ParameterNameCheck (12 lines)
    // @checkstyle ParameterNumber (12 lines)
    /**
     * Constructor for class CategoryServiceImpl.
     * @param orderRepository OrderRepository
     * @param opRepository OrderProductRepository
     * @param productRepository ProductRepository
     * @param session HttpSession
     */
    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository,
        final OrderProductRepository opRepository,
            final ProductRepository productRepository,
                final HttpSession session) {
        this.orderRepository = orderRepository;
        this.opRepository = opRepository;
        this.productRepository = productRepository;
        this.session = session;
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    // @checkstyle DesignForExtensionCheck (2 lines)
    @Override
    public Order create(final Order order) {
        return this.orderRepository.save(order);
    }

    // @checkstyle LocalVariableNameCheck (9 lines)
    // @checkstyle LocalFinalVariableNameCheck (16 lines)
    // @checkstyle DesignForExtensionCheck (4 lines)
    // @checkstyle ParameterNameCheck (3 lines)
    @SuppressWarnings("PMD.AvoidDuplicateLiterals")
    @Override
    public void addOrderProduct(final Integer productId) {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Order order = userSession.getOrder();
        OrderProduct orderProduct = this.opRepository.findByOrderAndProduct(
            order, this.productRepository.findById(productId).orElse(new Product())
        );
        if (orderProduct == null) {
            orderProduct = new OrderProduct(
                order, this.productRepository.findById(productId).orElse(new Product()),
        1, this.productRepository.findById(productId).orElse(new Product()).getPrice()
            );
            orderProduct.setOrder(order);
            orderProduct.setProduct(
                this.productRepository.findById(productId).orElse(new Product())
            );
            this.opRepository.save(orderProduct);
        } else {
            orderProduct.setQuantity(orderProduct.getQuantity() + 1);
            orderProduct.setSubPrice(
                orderProduct.getSubPrice() + orderProduct.getProduct().getPrice()
            );
            this.opRepository.save(orderProduct);
        }
    }

    // @checkstyle LocalFinalVariableNameCheck (8 lines)
    // @checkstyle DesignForExtensionCheck (4 lines)
    // @checkstyle ParameterNameCheck (2 lines)
    @Override
    public void removeOrderProduct(final Integer orderProductId) {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Order order = userSession.getOrder();
        for (final OrderProduct op: this.opRepository.findByOrder(order)) {
            final OrderProduct orderProduct = this.opRepository.findByOrderAndProduct(
                order, this.productRepository.findById(
                    op.getProduct().getId()
                ).orElse(new Product())
            );
            if (orderProduct.getId().equals(orderProductId)) {
                if (orderProduct.getQuantity() > 1) {
                    orderProduct.setQuantity(orderProduct.getQuantity() - 1);
                    orderProduct.setSubPrice(
                        orderProduct.getSubPrice() - orderProduct.getProduct().getPrice()
                    );
                    this.opRepository.save(orderProduct);
                } else {
                    this.opRepository.deleteById(orderProductId);
                }
            }
        }
    }
}
