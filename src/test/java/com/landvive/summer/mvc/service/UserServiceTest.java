package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.UserRequest;
import com.landvive.summer.mvc.entity.User;
import com.landvive.summer.mvc.repository.MemoryUserRepository;
import com.landvive.summer.mvc.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserServiceTest {

    UserService userService;
    UserRepository userRepository;

    //메서드가 돌아가기 전에 각각 실행
    @BeforeEach
    public void beforeEach() {
        this.userRepository = new MemoryUserRepository();
        this.userService = new UserService(userRepository);
    }

    @AfterEach
    public void afterEach() {
        userRepository.clearDb();
    }

    @Test
    void 회원가입() {
        //given
        UserRequest userRequest = new UserRequest("유지수", 1000);
        //when
        Long id = userService.join(userRequest);
        //then
        User user = userService.findById(id);

        Assertions.assertThat(user.getName()).isEqualTo(userRequest.getName());

    }

    @Test
    public void 중복회원_예제() {
        //given
        UserRequest userRequest1 = new UserRequest("유지수", 1000);
        UserRequest userRequest2 = new UserRequest("유지수", 2000);

        //when
        userService.join(userRequest1);

        //then 예외를 검증 할 땐 assertThrows
        assertThrows(IllegalStateException.class, () -> {
           userService.join(userRequest2);
        });
    }
}