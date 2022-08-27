package com.landvibe.week3.BookServiceSystem.controller;

import com.landvibe.week3.BookServiceSystem.dto.Req.ProductReq;
import com.landvibe.week3.BookServiceSystem.dto.Res.*;
import com.landvibe.week3.BookServiceSystem.entity.Product;
import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;
import com.landvibe.week3.BookServiceSystem.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public ProductRes create(@RequestBody ProductReq productReq) {
        Integer successProductCode = -1;
        Map<String, Long> productResult = new HashMap<>();

        Map<Integer, Long> codeAndResult;
        codeAndResult = productService.join(productReq);

        for (Integer code : codeAndResult.keySet()) {
            successProductCode = code;
            break;
        }
        for (Long resultId : codeAndResult.values()) {
            productResult.put("id", resultId);
            break;
        }
        return new ProductRes(successProductCode, productResult);
    }

    @GetMapping(value = "/products")
    public ProductsRes viewProductList() {

        Integer productSize = productService.getProductSize();

        ArrayList<Product> productArrayList
                = productService.getProductArrayList();

        return new ProductsRes(productSize, productArrayList);
    }

    @GetMapping(value = "/product/{productId}")
    public ProductDetailRes viewProductDetail(@PathVariable("productId") Long id) {
        ProductDetail productDetail = productService.findById(id);
        Map<String, ProductDetail> product = new HashMap<>();

        product.put("product", productDetail);

        return new ProductDetailRes(product);
    }
}















