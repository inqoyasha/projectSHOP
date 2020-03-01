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

import java.util.Optional;
import org.azamat.model.securitymodel.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is User Repository Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Method findByUsername interface method.
     * @param userName UserName
     * @return User
     */
    Optional<User> findByUsername(String userName);
}
