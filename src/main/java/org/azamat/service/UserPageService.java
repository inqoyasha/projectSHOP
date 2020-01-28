package org.azamat.service;

import org.azamat.model.UserPage;

import java.util.List;

public interface UserPageService {
    UserPage findById(int id);
    void save(UserPage userPage);
    void update(UserPage userPage);
}
