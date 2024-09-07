package com.example.estore.EstoreApp.service;

import com.example.estore.EstoreApp.entities.User;

import java.util.List;

public interface UserService {


    List<User> getUsers();

    void deleteUser(Long userId);

    User updateUser(Long userId, User userreq);

    User addUser(User user);

}
