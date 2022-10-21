package com.landvibe.summer.jpa.controller;

import com.landvibe.summer.jpa.dto.request.PostUserReq;
import com.landvibe.summer.jpa.dto.response.GetProductsRes;
import com.landvibe.summer.jpa.dto.response.PostUserRes;
import com.landvibe.summer.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public PostUserRes create(@RequestBody PostUserReq request) {
        return userService.join(request);
    }

    @GetMapping("/user/{userId}")
    public PostUserRes findUserInfo(@PathVariable(value = "userId") String userId) {
        return userService.getUserInfo(userId);
    }

    @GetMapping("/my-info")
    public PostUserRes findMyUserInfo() {
        return userService.getMyInfo();
    }

    @GetMapping("/my-products")
    public GetProductsRes findMyProducts() {
        return userService.getMyProducts();
    }
}