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

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * This is class entity of Role.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@SuppressWarnings("PMD.DataClass")
@Entity
@Table(name = "roles")
public class Role {

    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name.
     */
    private String name;

    /**
     * Collection of Users.
     */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<User> users;

    /**
     * Default constructor for Role.
     */
    @SuppressWarnings("PMD.UncommentedEmptyConstructor")
    public Role() {
    }

    /**
     * Constructor for Role with params.
     * @param name Name
     * @param users Users
     */
    public Role(final String name, final Collection<User> users) {
        this.name = name;
        this.users = users;
    }

    /**
     * Method get Role id.
     * @return Id
     */
    public Long getId() {
        return this.id;
    }

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set Role id.
     * @param id Id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Method get Role name.
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set Role name.
     * @param name Name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Method get Role users.
     * @return Users
     */
    public Collection<User> getUsers() {
        return this.users;
    }

    // @checkstyle HiddenField (5 lines)
    /**
     * Method set Role users.
     * @param users Users
     */
    public void setUsers(final Collection<User> users) {
        this.users = users;
    }
}
