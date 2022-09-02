package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.UserRequest;
import com.landvibe.summer.reservation.dto.response.Products;
import com.landvibe.summer.reservation.dto.response.ProductsResponse;
import com.landvibe.summer.reservation.dto.response.UserResponse;
import com.landvibe.summer.reservation.service.ProductService;
import com.landvibe.summer.reservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/signup")
    public UserResponse create(@RequestBody UserRequest request) {
        return userService.join(request);
    }

    @GetMapping("/user/{name}")
    @PreAuthorize("hasAnyRole('ADMIN')")//권한이 있을때만 볼수있게
    public UserResponse findUserByName(@PathVariable(value = "name") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/myinfo")
    @PreAuthorize("hasAnyRole('USER')")
    public UserResponse findMyInfo() {
        return userService.getMyInfo();
    }

    @GetMapping(value = "/myproducts")
    @PreAuthorize("hasAnyRole('USER')")
    public ProductsResponse getMyProducts() {
        List<Products> products = productService.myProducts();
        return new ProductsResponse(products.size(), products);
    }

}
