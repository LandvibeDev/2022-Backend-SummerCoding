package com.landvibe.summer.reservation.service;

import com.landvibe.summer.reservation.dto.request.UserRequest;
import com.landvibe.summer.reservation.dto.response.UserResponse;
import com.landvibe.summer.reservation.entity.Authority;
import com.landvibe.summer.reservation.entity.User;
import com.landvibe.summer.reservation.repository.UserRepository;
import com.landvibe.summer.reservation.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse join(UserRequest request) {

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();
        User user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(Collections.singleton(authority))
                .build();

        user = userRepository.save(user);

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Transactional
    public UserResponse getUserByName(String name) {
        User user = userRepository.findByName(name).orElseThrow(() -> new IllegalStateException("User not found"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Transactional
    public UserResponse getMyInfo() {
        String name = SecurityUtil.getCurrentUsername().orElseThrow(() -> new IllegalStateException("user not found"));
        User user = userRepository.findByName(name).orElseThrow(() -> new IllegalStateException("user not found"));

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
