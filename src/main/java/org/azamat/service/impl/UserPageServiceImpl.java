package org.azamat.service.impl;

import org.azamat.model.UserPage;
import org.azamat.repository.UserPageRepository;
import org.azamat.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public UserPage findByUsername(String userName) {
        return userPageRepository.findByUsername(userName);
    }

    @Override
    public void save(UserPage userPage) {
        userPageRepository.save(userPage);
    }

    @Override
    public void update(UserPage userPage) {
        userPageRepository.save(userPage);
    }
}
