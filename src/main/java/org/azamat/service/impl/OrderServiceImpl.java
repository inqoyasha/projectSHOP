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

import java.util.ArrayList;
import java.util.List;
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
    /**
     * OrderRepository.
     */
    private final OrderRepository orderRepository;

    /**
     * OrderProductRepository.
     */
    private final OrderProductRepository orderProductRepository;

    /**
     * ProductRepository.
     */
    private final ProductRepository productRepository;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    /**
     * Constructor for class CategoryServiceImpl.
     * @param orderRepository OrderRepository
     * @param orderProductRepository OrderProductRepository
     * @param productRepository ProductRepository
     * @param session HttpSession
     * @checkstyle ParameterNumber (6 lines)
     */
    @Autowired
    public OrderServiceImpl(final OrderRepository orderRepository,
        final OrderProductRepository orderProductRepository,
            final ProductRepository productRepository,
                final HttpSession session) {
        this.orderRepository = orderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
        this.session = session;
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(final Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void addOrderProduct(final Integer productId) {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Order order = userSession.getOrder();
        OrderProduct orderProduct = this.orderProductRepository.findByOrderAndProduct(
            order, this.productRepository.findById(productId).orElse(new Product())
        );
        if (orderProduct == null) {
            orderProduct = new OrderProduct(
                order, this.productRepository.findById(productId).orElse(new Product()),
        1, this.productRepository.findById(productId).orElse(new Product()).getPrice()
            );
            final List<OrderProduct> cart = new ArrayList<>(10);
            cart.add(orderProduct);
            orderProduct.setOrder(order);
            orderProduct.setProduct(
                this.productRepository.findById(productId).orElse(new Product())
            );
            this.orderProductRepository.save(orderProduct);
        } else {
            orderProduct.setQuantity(orderProduct.getQuantity() + 1);
            orderProduct.setSubPrice(
                orderProduct.getSubPrice() + orderProduct.getProduct().getPrice()
            );
            this.orderProductRepository.save(orderProduct);
        }
    }

    @Override
    public void removeOrderProduct(final Integer orderProductId) {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final Order order = userSession.getOrder();
        for (final OrderProduct op: this.orderProductRepository.findByOrder(order)) {
            final OrderProduct orderProduct = this.orderProductRepository.findByOrderAndProduct(
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
                    this.orderProductRepository.save(orderProduct);
                } else {
                    this.orderProductRepository.deleteById(orderProductId);
                }
            }
        }
    }
}
