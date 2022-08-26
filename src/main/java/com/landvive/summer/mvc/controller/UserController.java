package com.landvive.summer.mvc.controller;

import com.landvive.summer.mvc.dto.request.UserRequest;
import com.landvive.summer.mvc.dto.response.UserResponse;
import com.landvive.summer.mvc.entity.User;
import com.landvive.summer.mvc.repository.MemoryUserRepository;
import com.landvive.summer.mvc.repository.UserRepository;
import com.landvive.summer.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/user")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        Long userId = userService.join(userRequest);
        return new UserResponse(userId, null, null);
    }

    @GetMapping
    public UserResponse find(@RequestParam("name") String name) {
        User user = userService.findByName(name);
        return new UserResponse(user.getId(), user.getName(), user.getAccount());
    }
}
