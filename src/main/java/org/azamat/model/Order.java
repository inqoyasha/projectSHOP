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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.azamat.model.securitymodel.User;

/**
 * This is class entity of Order.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * User.
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Default constructor for Order.
     */
    public Order() {
    }

    /**
     * Constructor for Order with params.
     * @param id Id
     * @param user User
     */
    public Order(final Integer id, final User user) {
        this.id = id;
        this.user = user;
    }

    /**
     * Method get Order id.
     * @return Id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Method set Order id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Method get Order user.
     * @return User
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Method set Order user.
     * @param user User
     * @checkstyle HiddenField (2 lines)
     */
    public void setUser(final User user) {
        this.user = user;
    }
}
