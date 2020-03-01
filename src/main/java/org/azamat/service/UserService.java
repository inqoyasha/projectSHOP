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

import java.util.Collection;
import org.azamat.model.securitymodel.User;

/**
 * This is User Service interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface UserService {
    /**
     * Method registerUser interface method.
     * @param user User
     * @return User
     */
    User registerUser(User user);

    /**
     * Method getAll interface method.
     * @return Collection of Users
     */
    Collection<User> getAll();

    /**
     * Method findByUsername interface method.
     * @param username Username
     * @return User
     */
    User findByUsername(String username);

    /**
     * Method findById interface method.
     * @param id User id
     * @return User
     */
    User findById(Long id);

    /**
     * Method removeUser interface method.
     * @param id User id
     */
    void removeUser(Long id);

    /**
     * Method update interface method.
     * @param user User
     */
    void update(User user);
}
