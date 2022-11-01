package com.example.demo.service;

import com.example.demo.db.User;

import java.util.Iterator;
import java.util.List;

public interface UserService {
    Iterable<User> getAll();

    void add(User user);

    void deleteById(Long id);

    void update(User user);
}
