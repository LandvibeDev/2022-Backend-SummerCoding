package com.landvive.summer.mvc.controller;

import com.landvive.summer.mvc.dto.request.ProductRequest;
import com.landvive.summer.mvc.dto.response.*;
import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;
import com.landvive.summer.mvc.service.CategoryService;
import com.landvive.summer.mvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/product")
    @ResponseBody
    public ProductResponse create(@RequestBody ProductRequest request) {
        Long id = service.postProduct(request);

        if(id == -1) {
            return new ProductResponse(-1, null);
        }
        return new ProductResponse(0, request);
    }

    @GetMapping("/products")
    @ResponseBody
    public ProductsResponse findAll() {
        List<Product> productsList = service.getProductList();
        return new ProductsResponse(productsList.size(), productsList);
    }

    @GetMapping("/products/{productId}")
    @ResponseBody
    public ProductDetailResponse findDetails(@PathVariable ("productId") Long productId) {

        Product product = service.findById(productId);
        Category category = product.getCategory();

        return ProductDetailResponse.builder()
                .id(product.getId())
                .categoryId(category.getId())
                .categoryName(category.getName())
                .name(product.getName())
                .description(product.getDescription())
                .createdAt(product.getCreatedAt())
                .build();

    }

}