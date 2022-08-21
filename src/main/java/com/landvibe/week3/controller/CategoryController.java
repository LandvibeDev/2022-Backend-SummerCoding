package com.landvibe.week3.controller;

import com.landvibe.week3.dto.GetCategoryResDto;
import com.landvibe.week3.dto.PostCategoryReqDto;
import com.landvibe.week3.dto.PostCommonResDto;
import com.landvibe.week3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(path = "/category")
    public ResponseEntity<PostCommonResDto> postCategory(@RequestBody PostCategoryReqDto reqDto) {
        PostCommonResDto resDto = categoryService.create(reqDto.getName());

        return ResponseEntity.ok(resDto);
    }

    @GetMapping(path = "/categories")
    public ResponseEntity<GetCategoryResDto> getCategories() {
        GetCategoryResDto resDto = categoryService.getAllCategories();

        return ResponseEntity.ok(resDto);
    }
}
