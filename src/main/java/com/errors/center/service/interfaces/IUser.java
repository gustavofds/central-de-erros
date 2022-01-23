package com.errors.center.service.interfaces;

import com.errors.center.model.User;

public interface IUser {

    User save(User user);
    User findByLogin(String login);
}
