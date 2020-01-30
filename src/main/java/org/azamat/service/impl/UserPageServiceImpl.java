package org.azamat.service.impl;

import org.apache.catalina.User;
import org.azamat.model.UserPage;
import org.azamat.repository.UserPageRepository;
import org.azamat.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPageServiceImpl implements UserPageService {
    private final UserPageRepository userPageRepository;
    @Autowired
    public UserPageServiceImpl(UserPageRepository userPageRepository) {
        this.userPageRepository = userPageRepository;
    }

    @Override
    public UserPage findById(int id) {
        return this.userPageRepository.findById(id).orElse(null);
    }


    public UserPage findByUsername(String firstName, String lastName) {
        return userPageRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void save(UserPage userPage) {
        userPageRepository.save(userPage);
    }

    @Override
    public void update(UserPage userPage) {
        UserPage userFromDB = userPageRepository.findById(1).orElse(null);
        userFromDB.setFirstName(userPage.getFirstName());
        userFromDB.setLastName(userPage.getLastName());
        userFromDB.setPatronymic(userPage.getPatronymic());
        userFromDB.setEmail(userPage.getEmail());
        userFromDB.setAddress(userPage.getAddress());
        userPageRepository.save(userFromDB);
    }
}
