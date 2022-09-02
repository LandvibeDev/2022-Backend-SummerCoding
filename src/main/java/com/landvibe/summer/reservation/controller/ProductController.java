package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.dto.response.*;
import com.landvibe.summer.reservation.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = "/product")
    @PreAuthorize("hasAnyRole('USER')")
    public ProductResponse create(@RequestBody ProductRequest request) {
        Long productId = productService.create(request);
        return new ProductResponse(0, new Result(productId));
    }

    @GetMapping(value = "/products")
    @PreAuthorize("hasAnyRole('USER')")
    public ProductsResponse getProducts() {
        List<Products> products = productService.getProductsRes();
        return new ProductsResponse(products.size(), products);
    }

    @GetMapping("/product/{productId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ProductDetailResponse findById(@PathVariable("productId") Long id) {
        ProductDetail productDetail = productService.productDetail(id);
        return new ProductDetailResponse(productDetail);
    }
}
