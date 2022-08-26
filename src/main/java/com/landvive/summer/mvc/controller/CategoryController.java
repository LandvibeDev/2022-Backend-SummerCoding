package com.landvive.summer.mvc.controller;

import com.landvive.summer.mvc.config.BaseException;
import com.landvive.summer.mvc.config.BaseResponse;
import com.landvive.summer.mvc.dto.request.CategoryRequest;
import com.landvive.summer.mvc.dto.response.CategoriesResponse;
import com.landvive.summer.mvc.dto.response.CategoryResponse;
import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/category")
    @ResponseBody
    public CategoryResponse create(@RequestBody CategoryRequest request) {
            Long id = service.create(request);

            if(id == -1L) {
                return new CategoryResponse(-1, null);
            }

            return new CategoryResponse(0, request);
    }

    @GetMapping("/categories")
    @ResponseBody
    public CategoriesResponse findAll() {
        List<Category> categoryList = service.findAll();
        return new CategoriesResponse(categoryList.size(), categoryList);
    }
}
