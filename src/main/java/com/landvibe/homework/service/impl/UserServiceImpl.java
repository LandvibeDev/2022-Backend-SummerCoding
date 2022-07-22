package com.landvibe.homework.service.impl;

import com.landvibe.homework.entity.User;
import com.landvibe.homework.repository.UserRepository;
import com.landvibe.homework.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(String name, int credit) {
        if (userRepository.findByName(name) != null) {
            System.out.println("유저 생성 실패 - 이미 존재하는 이름입니다!! \n");
            return;
        }
        User user = new User(userRepository.getCount(), name, credit);
        userRepository.save(user);
        System.out.println("유저 생성 완료!!\n");
    }

    @Override
    public void checkCredit(User user) {
        System.out.println("잔액 : " + user.getCredit() + "원\n");
    }

    @Override
    public void earnCredit(User user, int value) {
        if (value > 0) {
            user.work(value);
            System.out.println("돈 벌기 완료!!\n");
        } else {
            System.out.println("0보다 큰 정수만 입력해 주세요\n");
        }
    }

    @Override
    public void printUserList() {
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println();
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
