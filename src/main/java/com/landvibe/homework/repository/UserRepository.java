package com.landvibe.homework.repository;

import com.landvibe.homework.entity.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    User findById(Long userId);

    User findByName(String userName);

    Long getCount();

    List<User> findAll();
}
