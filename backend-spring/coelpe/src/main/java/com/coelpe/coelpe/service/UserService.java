package com.coelpe.coelpe.service;

import com.coelpe.coelpe.entity.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User getUser(String email);
    List<User> getUsers();
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id);
}
