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

package org.azamat.repository;

import java.util.List;
import org.azamat.model.Order;
import org.azamat.model.OrderProduct;
import org.azamat.model.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * This is Order Product Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer> {
    /**
     * Method findByOrderAndProduct interface method.
     * @param order Order
     * @param product Product
     * @return OrderProduct
     */
    OrderProduct findByOrderAndProduct(Order order, Product product);

    /**
     * Method findByOrder interface method.
     * @param order Order
     * @return List of OrderProducts
     */
    List<OrderProduct> findByOrder(Order order);
}
