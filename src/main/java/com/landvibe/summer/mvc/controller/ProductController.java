package com.landvibe.summer.mvc.controller;

import com.landvibe.summer.mvc.dto.request.ProductRequest;
import com.landvibe.summer.mvc.dto.response.ProductDetailResponse;
import com.landvibe.summer.mvc.dto.response.ProductResponse;
import com.landvibe.summer.mvc.dto.response.ProductsResponse;
import com.landvibe.summer.mvc.entity.Product;
import com.landvibe.summer.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ProductResponse create(@RequestBody ProductRequest request) {
        Long productId = productService.register(request);
        if (productId.equals(-1L)) {
            return new ProductResponse(-1, null);
        }
        Map<String, Long> map = new HashMap<>();
        map.put("id", productId);
        return new ProductResponse(1, map);
    }

    @GetMapping("/products")
    public ProductsResponse read() {
        Integer size = productService.getProducts().size();
        List<Product> products = productService.getProducts();
        return new ProductsResponse(size, products);
    }

    @GetMapping("/product")
    public ProductDetailResponse read(@RequestParam("productId") Long productId) {
        Product product = productService.findById(productId);
        return new ProductDetailResponse(product);
    }
}