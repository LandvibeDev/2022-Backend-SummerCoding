package com.landvibe.homework.repository.impl;

import com.landvibe.homework.entity.User;
import com.landvibe.homework.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

    private static final Map<Long, User> store = new HashMap<>();

    @Override
    public void save(User user) {
        store.put(user.getId(), user);
    }

    @Override
    public User findById(Long userId) {
        return store.get(userId);
    }

    @Override
    public User findByName(String userName) {
        for (User user : store.values()) {
            if (user.getName().equals(userName))
                return user;
        }
        return null;
    }

    @Override
    public Long getCount() {
        return (long) store.size() + 1;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}
