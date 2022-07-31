package com.landvibe.homework.service;

import com.landvibe.homework.entity.User;

public interface UserService {
    void createUser(String name, int credit);

    void checkCredit(User user);

    void earnCredit(User user, int value);

    void printUserList();

    User findByName(String name);
}
