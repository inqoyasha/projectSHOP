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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.azamat.SpringBootStarter;
import org.azamat.model.Order;
import org.azamat.model.securitymodel.Role;
import org.azamat.model.securitymodel.Status;
import org.azamat.model.securitymodel.User;
import org.azamat.repository.RoleRepository;
import org.azamat.repository.UserRepository;
import org.azamat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * This is User Service implementation.
 *
 * Shamsutdinov Azamat
 * 0.1
 * @since 0.1
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootStarter.class);

    /**
     * UserRepository.
     */
    private final UserRepository userRepository;

    /**
     * RoleRepository.
     */
    private final RoleRepository roleRepository;

    /**
     * BCryptPasswordEncoder.
     */
    private final BCryptPasswordEncoder passwordEncoder;

    /**
     * HttpSession.
     */
    private final HttpSession session;

    /**
     * Constructor for class UserServiceImpl.
     * @param userRepository UserRepository
     * @param roleRepository RoleRepository
     * @param passwordEncoder BCryptPasswordEncoder
     * @param session HttpSession
     * @checkstyle ParameterNumber (6 lines)
     */
    @Autowired
    public UserServiceImpl(final UserRepository userRepository,
        final RoleRepository roleRepository,
            final BCryptPasswordEncoder passwordEncoder,
                final HttpSession session) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.session = session;
    }

    @Override
    public User registerUser(final User user) {
        final Role roleUser = this.roleRepository.findByName("ROLE_USER").orElse(new Role());
        final List<Role> userRoles = new ArrayList<>(2);
        final Order order = new Order();
        userRoles.add(roleUser);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setOrder(order);
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(Calendar.getInstance());
        order.setUser(user);
        final User registeredUser = this.userRepository.save(user);
        return registeredUser;
    }

    @Override
    public Collection<User> getAll() {
        final List<User> result = this.userRepository.findAll();
        LOGGER.info("getAll method - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(final String username) {
        final User result = this.userRepository.findByUsername(username).orElse(null);
        LOGGER.info("findByUsername method - user: {} found by username: {}", result, username);
        LOGGER.debug("findByUsername method - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(final Long id) {
        final User result = this.userRepository.findById(id).orElse(new User());
        LOGGER.info("findById method - user: {} found by id: {}", result, id);
        LOGGER.debug("findById method - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void removeUser(final Long id) {
        this.userRepository.deleteById(id);
        LOGGER.info("removeUser method - user with id: {} successfully deleted");
    }

    @Override
    public void update(final User user) {
        final User userSession = (User) this.session.getAttribute("connectedUser");
        final User userFromDB = this.userRepository
            .findById(userSession.getId()).orElse(new User());
        userFromDB.setFirstName(user.getFirstName());
        userFromDB.setLastName(user.getLastName());
        userFromDB.setPatronymic(user.getPatronymic());
        userFromDB.setEmail(user.getEmail());
        userFromDB.setAddress(user.getAddress());
        userFromDB.setUpdated(Calendar.getInstance());
        this.userRepository.save(userFromDB);
    }
}
