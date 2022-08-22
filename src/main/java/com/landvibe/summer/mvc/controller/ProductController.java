package com.landvibe.summer.mvc.controller;

import com.landvibe.summer.mvc.dto.request.PostProductReq;
import com.landvibe.summer.mvc.dto.response.GetProductDetailRes;
import com.landvibe.summer.mvc.dto.response.ProductInfoExceptDescription;
import com.landvibe.summer.mvc.dto.response.PostProductRes;
import com.landvibe.summer.mvc.dto.response.GetProductsRes;
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
    public PostProductRes create(@RequestBody PostProductReq request) {
        Long productId = productService.register(request);
        if (productId.equals(-1L)) {
            return new PostProductRes(-1, null);
        }
        Map<String, Long> map = new HashMap<>();
        map.put("id", productId);
        return new PostProductRes(1, map);
    }

    @GetMapping("/products")
    public GetProductsRes read() {
        List<ProductInfoExceptDescription> products = productService.getProducts();
        Integer size = products.size();
        return new GetProductsRes(size, products);
    }

    @GetMapping("/product")
    public GetProductDetailRes read(@RequestParam("productId") Long productId) {
        Product product = productService.findById(productId);
        return new GetProductDetailRes(product);
    }
}