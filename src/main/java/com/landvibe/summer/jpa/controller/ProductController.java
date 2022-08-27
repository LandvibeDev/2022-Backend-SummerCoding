package com.landvibe.summer.jpa.controller;

import com.landvibe.summer.jpa.dto.request.PostProductReq;
import com.landvibe.summer.jpa.dto.response.GetProductDetailRes;
import com.landvibe.summer.jpa.dto.response.GetProductsRes;
import com.landvibe.summer.jpa.dto.response.PostProductRes;
import com.landvibe.summer.jpa.entity.Product;
import com.landvibe.summer.jpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public PostProductRes create(@RequestBody PostProductReq request) {
        return productService.create(request);
    }

    @GetMapping("/products")
    public GetProductsRes read() {
        return productService.getProducts();
    }

    @GetMapping("/product")
    public GetProductDetailRes read(@RequestParam("productId") Long productId) {
        Product product = productService.findById(productId);
        return productService.getProductDetail(product);
    }
}