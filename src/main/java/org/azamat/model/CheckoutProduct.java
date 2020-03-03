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
@SuppressWarnings("PMD.DataClass")
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

    // @checkstyle MemberNameCheck (4 lines)
    /**
     * SubPrice.
     */
    private int subPrice;

    /**
     * Default constructor for CheckoutProduct.
     */
    @SuppressWarnings("PMD.UncommentedEmptyConstructor")
    public CheckoutProduct() {
    }

    // @checkstyle ParameterNameCheck (15 lines)
    // @checkstyle ParameterNumber (14 lines)
    /**
     * Constructor for CheckoutProduct with params.
     * @param id Id
     * @param checkout Checkout
     * @param product Product
     * @param quantity Quantity
     * @param subPrice SubPrice
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set CheckoutProduct id.
     * @param id Id
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set CheckoutProduct checkout.
     * @param checkout Checkout
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set CheckoutProduct product.
     * @param product Product
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set CheckoutProduct quantity.
     * @param quantity Quantity
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

    // @checkstyle ParameterNameCheck (6 lines)
    // @checkstyle HiddenField (5 lines)
    /**
     * Method set CheckoutProduct subPrice.
     * @param subPrice SubPrice
     */
    public void setSubPrice(final int subPrice) {
        this.subPrice = subPrice;
    }
}
