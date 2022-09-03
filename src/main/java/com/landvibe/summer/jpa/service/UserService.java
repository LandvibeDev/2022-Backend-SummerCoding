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
        if (getUser(request.getUserId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .userId(request.getUserId())
                .password(passwordEncoder.encode(request.getPassword()))
                .authorities(Collections.singleton(authority))
                .build();

        userRepository.save(user);

        return PostUserRes.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .build();
    }

    @Transactional
    public PostUserRes getUserByUserId(String userId) {
        User user = validate(userId);
        return PostUserRes.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .build();
    }

    @Transactional
    public PostUserRes getMyInfo() {
        String userId = getCurrentUserId();
        User user = validate(userId);
        return PostUserRes.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .build();
    }

    private User validate(String userId) {
        User user = getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자 입니다.");
        }
        return user;
    }

    @Transactional
    public GetProductsRes getMyProducts() {
        String userId = getCurrentUserId();
        List<Product> allProducts = productRepository.findAll();
        List<ProductsRes> products = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getSellerId().equals(userId)) {
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
    public String getCurrentUserId() {
        String userId = SecurityUtil.getCurrentUserId().orElse(null);
        if (userId == null) {
            throw new IllegalStateException("존재하지 않는 사용자입니다.");
        }
        return userId;
    }

    @Transactional
    public User getUser(String userId) {
        return userRepository.getUserByUserId(userId).orElse(null);
    }
}