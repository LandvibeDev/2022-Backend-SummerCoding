package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.UserRequest;
import com.landvive.summer.mvc.entity.User;
import com.landvive.summer.mvc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(UserRequest userRequest) {
        validateUser(userRequest);

        User newUser = new User(null, userRequest.getName(), userRequest.getAccount());
        userRepository.save(newUser);
        return newUser.getId();
    }

    private void validateUser(UserRequest userRequest) {
        userRepository.findByName(userRequest.getName()).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

    }

    //name을 통해서 유저를 가져옴
    public User findByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
                // 만약 null이면 예외로 던지겠다

    }

    //id를 통해서 유저를 가져옴
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원입니다."));
    }


}
