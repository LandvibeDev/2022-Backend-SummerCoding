package com.landvibe.week3.BookServiceSystem.service;

import com.landvibe.week3.BookServiceSystem.dto.Req.CategoryReq;
import com.landvibe.week3.BookServiceSystem.entity.Category;
import com.landvibe.week3.BookServiceSystem.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final List<Category> categoryList = new ArrayList<>();

    private Long sequence = 0L;

    @Transactional
    public void saveToDb(Category category) {
        categoryRepository.save(category);
    }

    @Transactional
    public Map<Integer, Long> join(CategoryReq categoryReq) {

        Integer successCode = validateDuplicatedCategory(categoryReq);

        Map<Integer, Long> codeAndResult1 = IsPossiblePost(successCode);
        if (codeAndResult1 != null) return codeAndResult1;
        //코드를 더 줄이는 방법을 모르겠습니다...

        Category category = Category.builder()
                .id(++sequence)
                .name(categoryReq.getName())
                .count(0)
                .build();
        saveToDb(category);

        Map<Integer, Long> codeAndResult = new HashMap<>() {{
            put(successCode, category.getId());
        }};
        categoryList.add(category);

        return codeAndResult;
    }

    @Transactional
    public Integer validateDuplicatedCategory(CategoryReq categoryReq) {
        if (categoryRepository.getReferenceByName(categoryReq.getName()).isPresent()) {

            return -1;
        } else
            return 0;
    }

    @Transactional
    public Map<Integer, Long> IsPossiblePost(Integer successCode) {
        if (successCode == -1) {
            return new HashMap<>() {{
                put(successCode, null);
            }};
        }
        return null;
    }

    @Transactional
    public List<Category> getCategoryList() {
        return categoryList;
    }

    @Transactional
    public Integer getCategorySize() {
        return categoryList.size();
    }

}
