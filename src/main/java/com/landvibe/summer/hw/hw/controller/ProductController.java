package com.landvibe.summer.hw.hw.controller;

import com.landvibe.summer.hw.hw.dto.request.ProductRequest;
import com.landvibe.summer.hw.hw.dto.response.ProductDetailResponse;
import com.landvibe.summer.hw.hw.dto.response.ProductListResponse;
import com.landvibe.summer.hw.hw.dto.response.ProductResponse;
import com.landvibe.summer.hw.hw.entity.Product;
import com.landvibe.summer.hw.hw.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ProductResponse create(@RequestBody ProductRequest request) {
        Map<String, Long> result = new HashMap<>();
        result.put("id", productService.register(request));
        return new ProductResponse(0, result);
    }

    @GetMapping("/products")
    public ProductListResponse getProductList(){
        Integer sz = productService.getProductListSize();
        Optional<List<Product>> list = productService.getProductList();
        ProductListResponse productListResponse = new ProductListResponse();
        productListResponse.setSz(sz);
        productListResponse.setProductList(list);
        return productListResponse;
    }

    @GetMapping("/product/{productId}")
    public Optional<ProductDetailResponse> getProductDetail(@PathVariable Long productId){
        return productService.getProductDetail(productId);
    }
}
