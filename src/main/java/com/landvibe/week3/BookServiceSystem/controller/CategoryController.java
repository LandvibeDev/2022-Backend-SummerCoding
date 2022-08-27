package com.landvibe.week3.BookServiceSystem.controller;

import com.landvibe.week3.BookServiceSystem.dto.Req.CategoryReq;
import com.landvibe.week3.BookServiceSystem.dto.Res.CategoriesRes;
import com.landvibe.week3.BookServiceSystem.dto.Res.CategoryRes;
import com.landvibe.week3.BookServiceSystem.entity.Category;
import com.landvibe.week3.BookServiceSystem.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    public CategoryRes create(@RequestBody CategoryReq categoryReq) {
        Integer successCode = -1;
        Map<String, Long> result = new HashMap<>();

        Map<Integer, Long> codeAndResult = categoryService.join(categoryReq);

        for (Integer code : codeAndResult.keySet()) {
            successCode = code;
            break;
        }
        for (Long resultId : codeAndResult.values()) {
            result.put("id", resultId);
            break;
        }
        return new CategoryRes(successCode, result);
    }

    @GetMapping("/categories")
    public CategoriesRes view() {

        Integer categorySize = categoryService.getCategorySize();

        List<Category> categoryList
                = categoryService.getCategoryList();

        return new CategoriesRes(categorySize, categoryList);
    }
}
