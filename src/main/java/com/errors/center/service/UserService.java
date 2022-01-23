package com.errors.center.service;

import com.errors.center.model.User;
import com.errors.center.repository.UserRepository;
import com.errors.center.service.interfaces.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUser {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }
}
