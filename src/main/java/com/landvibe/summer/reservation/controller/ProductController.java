package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.dto.response.ProductDetailResponse;
import com.landvibe.summer.reservation.dto.response.ProductResponse;
import com.landvibe.summer.reservation.dto.response.ProductsResponse;
import com.landvibe.summer.reservation.dto.response.Result;
import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @RequestMapping(value = "/api/product", method = RequestMethod.POST)
    @ResponseBody
    public ProductResponse create(@RequestBody ProductRequest request) {
        Long productId = productService.join(request);
        return new ProductResponse(1, new Result(productId));
    }

    @RequestMapping(value = "/api/products", method = RequestMethod.GET)
    public ProductsResponse lookUp() {
        ArrayList<Product> products = productService.lookUp();
        return new ProductsResponse(products.size(), products);
    }

    @GetMapping("/api/product/{productId}")
    public ProductDetailResponse findByName(@PathVariable("productId") Long id) {
        return new ProductDetailResponse(productService.findById(id));
    }

}
