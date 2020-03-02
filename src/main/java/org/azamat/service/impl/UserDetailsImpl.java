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

import java.util.Collection;
import java.util.stream.Collectors;
import org.azamat.model.securitymodel.Status;
import org.azamat.model.securitymodel.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * This is UserDetails implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
public class UserDetailsImpl implements UserDetails {
    /**
     * Id.
     */
    private Long id;

    /**
     * Username.
     */
    private String username;

    /**
     * Password.
     */
    private String password;

    /**
     * Status.
     */
    private boolean enabled;

    /**
     * Authorities.
     */
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * Constructor for class UserDetailsImpl.
     * @param user User
     */
    public UserDetailsImpl(final User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.getStatus().equals(Status.ACTIVE);
        this.authorities = user.getRoles().stream().map(
            role -> new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    /**
     * Method get User id.
     * @return Id
     */
    public Long getId() {
        return this.id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
