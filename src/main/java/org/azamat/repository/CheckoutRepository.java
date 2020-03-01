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
import org.azamat.model.Checkout;
import org.azamat.model.securitymodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is Checkout Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface CheckoutRepository extends JpaRepository<Checkout, Integer> {
    /**
     * Method findByUser interface method.
     * @param user User
     * @return List of Checkouts
     */
    List<Checkout> findByUser(User user);
}
