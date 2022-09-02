package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.LoginRequest;
import com.landvibe.summer.reservation.dto.response.TokenResponse;
import com.landvibe.summer.reservation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        String jwt = authService.login(request);
        return new ResponseEntity<>(new TokenResponse(jwt), generateHeader(jwt), HttpStatus.OK);
    }

    private HttpHeaders generateHeader(String jwt) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-access-token", jwt);
        return httpHeaders;
    }
}
