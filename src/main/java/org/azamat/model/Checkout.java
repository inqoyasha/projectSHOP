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

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.azamat.model.securitymodel.User;
import org.springframework.data.annotation.CreatedDate;

/**
 * This is class entity of Checkout.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
@Table(name = "checkouts")
public class Checkout {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    /**
     * User.
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Name.
     */
    private String name;

    /**
     * DateCreated.
     */
    @CreatedDate
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    /**
     * Status.
     */
    @Enumerated(EnumType.STRING)
    private CheckoutStatus status;

    /**
     * Collection of CheckoutProducts.
     */
    @Transient
    private Collection<CheckoutProduct> checkoutProducts;

    /**
     * Default constructor for Checkout.
     */
    public Checkout() {
    }

    /**
     * Constructor for Category with params.
     * @param id Id
     * @param user User
     * @param name Name
     * @param dateCreated DateCreated
     * @param status Status
     * @param checkoutProducts CheckoutProducts
     * @checkstyle ParameterNumber (7 lines)
     */
    public Checkout(final Integer id,
        final User user,
            final String name,
                final LocalDateTime dateCreated,
                    final CheckoutStatus status,
                        final Collection<CheckoutProduct> checkoutProducts) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.dateCreated = dateCreated;
        this.status = status;
        this.checkoutProducts = checkoutProducts;
    }

    /**
     * Method get checkout id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Method set checkout id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Method get checkout user.
     * @return User
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Method set checkout user.
     * @param user User
     * @checkstyle HiddenField (2 lines)
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Method get checkout name.
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method set checkout name.
     * @param name Name
     * @checkstyle HiddenField (2 lines)
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method get checkout dateCreated.
     * @return DateCreated
     */
    public LocalDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Method set checkout name.
     * @param dateCreated DateCreated
     * @checkstyle HiddenField (2 lines)
     */
    public void setDateCreated(final LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Method get checkout status.
     * @return Status
     */
    public CheckoutStatus getStatus() {
        return this.status;
    }

    /**
     * Method set checkout status.
     * @param status Status
     * @checkstyle HiddenField (2 lines)
     */
    public void setStatus(final CheckoutStatus status) {
        this.status = status;
    }

    /**
     * Method get checkout Collection of CheckoutProducts.
     * @return Status
     */
    public Collection<CheckoutProduct> getCheckoutProducts() {
        return this.checkoutProducts;
    }

    /**
     * Method set checkout Collection of CheckoutProducts.
     * @param checkoutProducts CheckoutProducts
     * @checkstyle HiddenField (2 lines)
     */
    public void setCheckoutProducts(final Collection<CheckoutProduct> checkoutProducts) {
        this.checkoutProducts = checkoutProducts;
    }
}

