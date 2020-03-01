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
import org.azamat.model.securitymodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is Role Repository interface.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Method findByName interface method.
     * @param name Name
     * @return Role
     */
    Optional<Role> findByName(String name);
}
