package com.codegym.services;

import com.codegym.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void save(User customer);

    void remove(Long id);
}
