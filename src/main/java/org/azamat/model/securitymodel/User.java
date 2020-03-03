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
@SuppressWarnings({"PMD.DataClass", "PMD.OnlyOneConstructorShouldDoInitialization"})
@Entity
@Table(name = "users")
public class User {
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @checkstyle MemberNameCheck (5 lines)
    /**
     * Username.
     */
    @Column(name = "username")
    private String username;

    // @checkstyle MemberNameCheck (5 lines)
    /**
     * User firstName.
     */
    @Column(name = "first_name")
    private String firstName;

    // @checkstyle MemberNameCheck (5 lines)
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
    @SuppressWarnings("PMD.UncommentedEmptyConstructor")
    public User() {
    }

    // @checkstyle ParameterNameCheck (14 lines)
    // @checkstyle ParameterNumber (13 lines)
    /**
     * Constructor for User with params.
     * @param firstName FirstName
     * @param lastName LastName
     * @param patronymic Patronymic
     * @param email Email
     * @param address Address
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

    // @checkstyle ParameterNameCheck (28 lines)
    // @checkstyle ParameterNumber (27 lines)
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
     */
    @SuppressWarnings("PMD.ExcessiveParameterList")
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User id.
     * @param id Id
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User username.
     * @param username Username
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

    // @checkstyle ParameterNameCheck (6 lines)
    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User firstName.
     * @param firstName FirstName
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

    // @checkstyle ParameterNameCheck (7 lines)
    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User lastName.
     * @param lastName LastName
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User email.
     * @param email Email
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User password.
     * @param password Password
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User date created.
     * @param created Created
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User date updated.
     * @param updated Updated
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User status.
     * @param status Status
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User roles.
     * @param roles Roles
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User patronymic.
     * @param patronymic Patronymic
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User address.
     * @param address Address
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User order.
     * @param order Order
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

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set User checkouts.
     * @param checkouts Checkouts
     */
    public void setCheckouts(final Collection<Checkout> checkouts) {
        this.checkouts = checkouts;
    }
}
