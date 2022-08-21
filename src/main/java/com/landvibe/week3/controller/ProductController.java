package com.landvibe.week3.controller;

import com.landvibe.week3.dto.GetProductDetailResDto;
import com.landvibe.week3.dto.GetProductResDto;
import com.landvibe.week3.dto.PostCommonResDto;
import com.landvibe.week3.dto.PostProductReqDto;
import com.landvibe.week3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping(path = "/product")
    public ResponseEntity<PostCommonResDto> postProduct(@RequestBody PostProductReqDto reqDto) {
        PostCommonResDto resDto = productService.create(reqDto);

        return ResponseEntity.ok(resDto);
    }

    @GetMapping(path = "/products")
    public ResponseEntity<GetProductResDto> getProducts() {
        GetProductResDto resDto = productService.getAll();

        return ResponseEntity.ok(resDto);
    }

    @GetMapping(path = "/product/{productId}")
    public ResponseEntity<GetProductDetailResDto> getProductDetail(@PathVariable(name = "productId") Long productId) {
        GetProductDetailResDto resDto = productService.getDetail(productId);

        return ResponseEntity.ok(resDto);
    }
}
