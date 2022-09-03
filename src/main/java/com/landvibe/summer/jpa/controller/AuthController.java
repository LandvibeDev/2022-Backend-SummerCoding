package com.landvibe.summer.jpa.controller;

import com.landvibe.summer.jpa.dto.request.LoginReq;
import com.landvibe.summer.jpa.dto.response.TokenRes;
import com.landvibe.summer.jpa.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenRes> login(@RequestBody LoginReq request) {
        String jwt = authService.login(request);
        return new ResponseEntity<>(new TokenRes(jwt), generateHeader(jwt), HttpStatus.OK);
    }

    private HttpHeaders generateHeader(String jwt) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-access-token", jwt);
        return httpHeaders;
    }
}