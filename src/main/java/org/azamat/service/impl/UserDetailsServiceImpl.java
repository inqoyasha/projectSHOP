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

package org.azamat.service.impl;

import org.azamat.model.securitymodel.User;
import org.azamat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is UserDetailsService implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    // @checkstyle MemberNameCheck (4 lines)
    /**
     * UserRepository.
     */
    private final UserRepository userRepository;

    // @checkstyle ParameterNameCheck (6 lines)
    /**
     * Constructor for class UserDetailsServiceImpl.
     * @param userRepository UserRepository
     */
    @Autowired
    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @checkstyle DesignForExtensionCheck (3 lines)
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User user = this.userRepository.findByUsername(username)
            .orElseThrow(()
                -> new UsernameNotFoundException(
                    new StringBuilder("user ").append(username).append(" not found").toString()
                )
            );
        return new UserDetailsImpl(user);
    }
}
