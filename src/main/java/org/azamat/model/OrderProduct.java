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

package org.azamat.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This is class entity of OrderProduct.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
@Table(name = "order_product")
public class OrderProduct {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Product.
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Order.
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * Quantity.
     */
    private int quantity;

    /**
     * SubPrice.
     */
    private int subPrice;

    /**
     * Default constructor for OrderProduct.
     */
    public OrderProduct() {
    }

    /**
     * Constructor for OrderProduct with params.
     * @param order Order
     * @param product Product
     * @param quantity Quantity
     * @param subPrice SubPrice
     * @checkstyle ParameterNumber (6 lines)
     */
    public OrderProduct(final Order order,
        final Product product,
            final int quantity,
                final int subPrice) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.subPrice = subPrice;
    }

    /**
     * Method get OrderProduct id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Method set OrderProduct id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Method get OrderProduct order.
     * @return Order
     */
    public Order getOrder() {
        return this.order;
    }

    /**
     * Method set OrderProduct order.
     * @param order Order
     * @checkstyle HiddenField (2 lines)
     */
    public void setOrder(final Order order) {
        this.order = order;
    }

    /**
     * Method get OrderProduct product.
     * @return Product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Method set OrderProduct product.
     * @param product Product
     * @checkstyle HiddenField (2 lines)
     */
    public void setProduct(final Product product) {
        this.product = product;
    }

    /**
     * Method get OrderProduct quantity.
     * @return Quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Method set OrderProduct quantity.
     * @param quantity Quantity
     * @checkstyle HiddenField (2 lines)
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    /**
     * Method get OrderProduct subPrice.
     * @return SubPrice
     */
    public int getSubPrice() {
        return this.subPrice;
    }

    /**
     * Method set OrderProduct subPrice.
     * @param subPrice SubPrice
     * @checkstyle HiddenField (2 lines)
     */
    public void setSubPrice(final int subPrice) {
        this.subPrice = subPrice;
    }
}
