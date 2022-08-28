package com.landvibe.summer.jpa.controller;

import com.landvibe.summer.jpa.dto.request.PostCategoryReq;
import com.landvibe.summer.jpa.dto.response.GetCategoriesRes;
import com.landvibe.summer.jpa.dto.response.PostCommonRes;
import com.landvibe.summer.jpa.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/category")
    public PostCommonRes create(@RequestBody PostCategoryReq request) {
        return categoryService.create(request);
    }

    @GetMapping("/categories")
    public GetCategoriesRes read() {
        return categoryService.getCategories();
    }
}