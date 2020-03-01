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

package org.azamat.model.securitymodel;

import java.util.Calendar;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.azamat.model.Checkout;
import org.azamat.model.Order;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * This is class entity of User.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Username.
     */
    @Column(name = "username")
    private String username;

    /**
     * User firstName.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * User lastName.
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * User patronymic.
     */
    private String patronymic;

    /**
     * User address.
     */
    private String address;

    /**
     * User email.
     */
    private String email;

    /**
     * User password.
     */
    private String password;

    /**
     * Date created.
     */
    @CreatedDate
    @Column(name = "date_created")
    private Calendar created;

    /**
     * Date updated.
     */
    @LastModifiedDate
    @Column(name = "date_updated")
    private Calendar updated;

    /**
     * User status.
     */
    @Enumerated(EnumType.STRING)
    private Status status;

    /**
     * User order.
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    /**
     * User roles.
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Collection<Role> roles;

    /**
     * User checkouts.
     */
    @Transient
    private Collection<Checkout> checkouts;

    /**
     * Default constructor for User.
     */
    public User() {
    }

    /**
     * Constructor for User with params.
     * @param firstName FirstName
     * @param lastName LastName
     * @param patronymic Patronymic
     * @param email Email
     * @param address Address
     * @checkstyle ParameterNumber (6 lines)
     */
    public User(final String firstName,
        final String lastName,
            final String patronymic,
                final String email,
                    final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.email = email;
    }

    /**
     * Constructor for User with params.
     * @param id Id
     * @param username Username
     * @param firstName FirstName
     * @param lastName LastName
     * @param patronymic Patronymic
     * @param address Address
     * @param email Email
     * @param password Password
     * @param created Created
     * @param updated Updated
     * @param status Status
     * @param roles Roles
     * @param checkouts Checkouts
     * @checkstyle ParameterNumber (14 lines)
     */
    public User(final Long id,
        final String username,
            final String firstName,
            final String lastName,
            final String patronymic,
            final String address,
            final String email,
            final String password,
            final Calendar created,
            final Calendar updated,
            final Status status,
            final Collection<Role> roles,
            final Collection<Checkout> checkouts) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.email = email;
        this.password = password;
        this.created = created;
        this.updated = updated;
        this.status = status;
        this.roles = roles;
        this.checkouts = checkouts;
    }

    /**
     * Method get User id.
     * @return Id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Method set User id.
     * @param id Id
     * @checkstyle HiddenField (2 lines)
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method get User username.
     * @return Username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Method set User username.
     * @param username Username
     * @checkstyle HiddenField (2 lines)
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Method get User firstName.
     * @return FirstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Method set User firstName.
     * @param firstName FirstName
     * @checkstyle HiddenField (2 lines)
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method get User lastName.
     * @return LastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Method set User lastName.
     * @param lastName LastName
     * @checkstyle HiddenField (2 lines)
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method get User email.
     * @return Email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Method set User email.
     * @param email Email
     * @checkstyle HiddenField (2 lines)
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Method get User password.
     * @return Password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Method set User password.
     * @param password Password
     * @checkstyle HiddenField (2 lines)
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Method get User date created.
     * @return Created
     */
    public Calendar getCreated() {
        return this.created;
    }

    /**
     * Method set User date created.
     * @param created Created
     * @checkstyle HiddenField (2 lines)
     */
    public void setCreated(final Calendar created) {
        this.created = created;
    }

    /**
     * Method get User date updated.
     * @return Updated
     */
    public Calendar getUpdated() {
        return this.updated;
    }

    /**
     * Method set User date updated.
     * @param updated Updated
     * @checkstyle HiddenField (2 lines)
     */
    public void setUpdated(final Calendar updated) {
        this.updated = updated;
    }

    /**
     * Method get User status.
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Method set User status.
     * @param status Status
     * @checkstyle HiddenField (2 lines)
     */
    public void setStatus(final Status status) {
        this.status = status;
    }

    /**
     * Method get User roles.
     * @return Roles
     */
    public Collection<Role> getRoles() {
        return this.roles;
    }

    /**
     * Method set User roles.
     * @param roles Roles
     * @checkstyle HiddenField (2 lines)
     */
    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }

    /**
     * Method get User patronymic.
     * @return Patronymic
     */
    public String getPatronymic() {
        return this.patronymic;
    }

    /**
     * Method set User patronymic.
     * @param patronymic Patronymic
     * @checkstyle HiddenField (2 lines)
     */
    public void setPatronymic(final String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Method get User address.
     * @return Address
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Method set User address.
     * @param address Address
     * @checkstyle HiddenField (2 lines)
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Method get User order.
     * @return Order
     */
    public Order getOrder() {
        return this.order;
    }

    /**
     * Method set User order.
     * @param order Order
     * @checkstyle HiddenField (2 lines)
     */
    public void setOrder(final Order order) {
        this.order = order;
    }

    /**
     * Method get User checkouts.
     * @return Checkouts
     */
    public Collection<Checkout> getCheckouts() {
        return this.checkouts;
    }

    /**
     * Method set User checkouts.
     * @param checkouts Checkouts
     * @checkstyle HiddenField (2 lines)
     */
    public void setCheckouts(final Collection<Checkout> checkouts) {
        this.checkouts = checkouts;
    }
}
