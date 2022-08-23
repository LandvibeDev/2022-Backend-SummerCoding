package com.landvibe.summer.reservation.controller;

import com.landvibe.summer.reservation.dto.request.CategoryRequest;
import com.landvibe.summer.reservation.dto.request.ProductRequest;
import com.landvibe.summer.reservation.dto.response.*;
import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.service.CategoryService;
import com.landvibe.summer.reservation.service.ProductService;
import lombok.RequiredArgsConstructor;
import com.landvibe.summer.reservation.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CategoryController {
    private final CategoryService categoryService;


    @ResponseBody
    @PostMapping(value = "category")
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        Long categoryId = categoryService.join(request);
        if (categoryId == -1) {
            return new CategoryResponse(-1);
        }
        return new CategoryResponse(0, new Result(categoryId));
    }

    @GetMapping(value = "categories")
    public CategoriesResponse lookUp() {
        List<Category> categories = categoryService.lookUp();
        return new CategoriesResponse(categories.size(), (ArrayList)categories);
    }
}
