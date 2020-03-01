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
 * This is class entity of CheckoutProduct.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
@Table(name = "checkout_product")
public class CheckoutProduct {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Checkout.
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "checkout_id")
    private Checkout checkout;

    /**
     * Product.
     */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Quantity.
     */
    private int quantity;

    /**
     * SubPrice.
     */
    private int subPrice;

    /**
     * Default constructor for CheckoutProduct.
     */
    public CheckoutProduct() {
    }

    /**
     * Constructor for CheckoutProduct with params.
     * @param id Id
     * @param checkout Checkout
     * @param product Product
     * @param quantity Quantity
     * @param subPrice SubPrice
     * @checkstyle ParameterNumber (6 lines)
     */
    public CheckoutProduct(final Integer id,
        final Checkout checkout,
            final Product product,
                final int quantity,
                    final int subPrice) {
        this.id = id;
        this.checkout = checkout;
        this.product = product;
        this.quantity = quantity;
        this.subPrice = subPrice;
    }

    /**
     * Method get CheckoutProduct id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Method set CheckoutProduct id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Method get CheckoutProduct checkout.
     * @return Checkout
     */
    public Checkout getCheckout() {
        return this.checkout;
    }

    /**
     * Method set CheckoutProduct checkout.
     * @param checkout Checkout
     * @checkstyle HiddenField (2 lines)
     */
    public void setCheckout(final Checkout checkout) {
        this.checkout = checkout;
    }

    /**
     * Method get CheckoutProduct product.
     * @return Product
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Method set CheckoutProduct product.
     * @param product Product
     * @checkstyle HiddenField (2 lines)
     */
    public void setProduct(final Product product) {
        this.product = product;
    }

    /**
     * Method get CheckoutProduct quantity.
     * @return Quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Method set CheckoutProduct quantity.
     * @param quantity Quantity
     * @checkstyle HiddenField (2 lines)
     */
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    /**
     * Method get CheckoutProduct subPrice.
     * @return SubPrice
     */
    public int getSubPrice() {
        return this.subPrice;
    }

    /**
     * Method set CheckoutProduct subPrice.
     * @param subPrice SubPrice
     * @checkstyle HiddenField (2 lines)
     */
    public void setSubPrice(final int subPrice) {
        this.subPrice = subPrice;
    }
}
