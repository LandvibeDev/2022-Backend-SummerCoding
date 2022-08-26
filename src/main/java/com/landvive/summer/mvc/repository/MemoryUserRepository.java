package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryUserRepository implements UserRepository {
    private static Map<Long, User> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public User save(User user) {
        user.setId(++sequence);
        db.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    @Override
    public Optional<User> findByName(String name) {
        /*
        for(User user : db.values()) {
            if(name.equals(user.getName())) {
                return Optional.of(user);
            }
        }
        */

        return db.values().stream()
                .filter(user -> name.equals(user.getName()))
                .findAny(); //찾으면 던져라

    }

    @Override
    public void clearDb() {
        db.clear();
    }
}
