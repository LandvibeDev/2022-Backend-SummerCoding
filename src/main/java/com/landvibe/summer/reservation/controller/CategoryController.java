package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.CategoryRequest;

import com.landvibe.summer.reservation.dto.response.*;
import com.landvibe.summer.reservation.dto.response.CategoryDetail;
import com.landvibe.summer.reservation.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;

    @ResponseBody
    @PostMapping(value = "category")
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        Long categoryId = categoryService.create(request);
        return new CategoryResponse(0, new Result(categoryId));
    }


    @GetMapping(value = "categories")
    public CategoriesResponse getCategories() {
        List<CategoryDetail> categories = categoryService.getCategories();
        return new CategoriesResponse(categories.size(), categories);
    }

}
