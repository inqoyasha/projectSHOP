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
import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;

/**
 * This is Order Product Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface OrderProductService {
    /**
     * Method create interface method.
     * @param orderProduct OrderProduct
     * @return OrderProduct
     */
    OrderProduct create(OrderProduct orderProduct);

    /**
     * Method findAllByOrder interface method.
     * @param order Order
     * @return OrderProduct
     */
    List<OrderProduct> findAllByOrder(Order order);

    /**
     * Method remove by OrderProduct id interface method.
     * @param id OrderProduct id
     */
    void remove(int id);

    /**
     * Method removeAll interface method.
     */
    void removeAll();

    /**
     * Method cartCount interface method.
     * @return CartCount
     */
    int cartCount();

    /**
     * Method getTotalPrice interface method.
     * @param orderProducts List of OrderProducts
     * @return TotalPrice
     */
    int getTotalPrice(List<OrderProduct> orderProducts);

    /**
     * Method findByOrderAndProduct interface method.
     * @param order Order
     * @param product Product
     * @return CheckoutProduct
     */
    OrderProduct findByOrderAndProduct(Order order, Product product);
}

