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

import org.azamat.model.Order;

/**
 * This is Order Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface OrderService {
    /**
     * Method getAllOrders interface method.
     * @return Order
     */
    Iterable<Order> getAllOrders();

    /**
     * Method create interface method.
     * @param order Order
     * @return Order
     */
    Order create(Order order);

    // @checkstyle ParameterNameCheck (5 lines)
    /**
     * Method addOrderProduct interface method.
     * @param productId Product id
     */
    void addOrderProduct(Integer productId);

    // @checkstyle ParameterNameCheck (5 lines)
    /**
     * Method removeOrderProduct interface method.
     * @param orderProductId Order product id
     */
    void removeOrderProduct(Integer orderProductId);
}
