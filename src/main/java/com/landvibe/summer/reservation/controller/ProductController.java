package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.dto.response.*;
import com.landvibe.summer.reservation.entity.*;
import com.landvibe.summer.reservation.service.CategoryService;
import com.landvibe.summer.reservation.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @PostMapping(value = "/product")
    @ResponseBody
    public ProductResponse create(@RequestBody ProductRequest request) {
        Long productId = productService.join(request);
        if (productId == -1) {
            return new ProductResponse(-1);
        }
        return new ProductResponse(0, new Result(productId));
    }

    @GetMapping(value = "products")
    public ProductsResponse lookUp() {
        ArrayList<Product> products = productService.lookUp();
        return new ProductsResponse(products.size(), products);
    }

    @GetMapping("/product/{productId}")
    public ProductDetailResponse findById(@PathVariable("productId") Long id) {
        Product product = productService.findById(id);
        Category category = categoryService.findById(product.getCategoryId());
        ProductDetail productDetail = ProductDetail.builder()
                .categoryId(category.getCateId())
                .categoryName(category.getCateName())
                .name(product.getName())
                .description(product.getDescription())
                .id(product.getId())
                .createdAt(product.getCreatedAt())
                .build();
        return new ProductDetailResponse(productDetail);
    }
}
