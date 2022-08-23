package com.landvibe.week3.BookServiceSystem.service;

import com.landvibe.week3.BookServiceSystem.dto.Req.CategoryReq;
import com.landvibe.week3.BookServiceSystem.entity.Category;
import com.landvibe.week3.BookServiceSystem.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ArrayList<Category> categoryArrayList
            = new ArrayList<>();

    public Map<Integer, Long> join(CategoryReq categoryReq) {

        Map<Integer, Long> codeAndResult = new HashMap<>();

        Integer successCode = validateDuplicatedCategory(categoryReq);
        Map<Integer, Long> codeAndResult1 = IsPossiblePost(codeAndResult, successCode);

        if (codeAndResult1 != null) return codeAndResult1;

        Category newCategory = new Category(null, categoryReq.getName(), 0);
        categoryRepository.save(newCategory);
        codeAndResult.put(successCode, newCategory.getId());
        categoryArrayList.add(newCategory);

        return codeAndResult;
    }


    private Integer validateDuplicatedCategory(CategoryReq categoryReq) {
        Optional<Category> category = categoryRepository.findByCategoryName(categoryReq.getName());

        if (category.isPresent())
            return -1;
        else
            return 0;
    }

    private Map<Integer, Long> IsPossiblePost(Map<Integer, Long> codeAndResult, Integer successCode) {
        if (successCode == -1) {
            codeAndResult.put(successCode, null);
            return codeAndResult;
        }
        return null;
    }

    public ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public Integer getCategorySize() {
        return categoryArrayList.size();
    }

}
