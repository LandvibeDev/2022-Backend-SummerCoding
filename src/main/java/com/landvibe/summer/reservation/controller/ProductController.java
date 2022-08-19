package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.dto.response.*;
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
        if (productId == -1) {
            return new ProductResponse(-1);
        }
        return new ProductResponse(0, new Result(productId));
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
