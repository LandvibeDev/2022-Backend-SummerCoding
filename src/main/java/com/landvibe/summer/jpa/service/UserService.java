package com.landvibe.summer.jpa.service;

import com.landvibe.summer.jpa.dto.request.PostUserReq;
import com.landvibe.summer.jpa.dto.response.GetProductsRes;
import com.landvibe.summer.jpa.dto.response.PostUserRes;
import com.landvibe.summer.jpa.dto.response.ProductsRes;
import com.landvibe.summer.jpa.entity.Authority;
import com.landvibe.summer.jpa.entity.Product;
import com.landvibe.summer.jpa.entity.User;
import com.landvibe.summer.jpa.repository.ProductRepository;
import com.landvibe.summer.jpa.repository.UserRepository;
import com.landvibe.summer.jpa.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public PostUserRes join(PostUserReq request) {
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(Collections.singleton(authority))
                .build();

        userRepository.save(user);

        return PostUserRes.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Transactional
    public PostUserRes getUserByName(String name) {
        User user = validate(name);
        return PostUserRes.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Transactional
    public PostUserRes getMyInfo() {
        String name = getCurrentUserName();
        User user = validate(name);
        return PostUserRes.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    @Transactional
    public GetProductsRes getMyProducts() {
        String name = getCurrentUserName();
        List<Product> allProducts = productRepository.findAll();
        List<ProductsRes> products = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getSellerName().equals(name)) {
                ProductsRes productsRes = ProductsRes.builder()
                        .id(product.getId())
                        .categoryId(product.getCategoryId())
                        .name(product.getName())
                        .createdAt(product.getCreatedAt())
                        .build();
                products.add(productsRes);
            }
        }
        return GetProductsRes.builder()
                .size(products.size())
                .products(products)
                .build();
    }

    @Transactional
    public String getCurrentUserName() {
        String name = SecurityUtil.getCurrentUsername().orElse(null);
        if (name == null) {
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        return name;
    }

    @Transactional
    public User validate(String name) {
        User user = userRepository.getUserByName(name).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
        return user;
    }
}