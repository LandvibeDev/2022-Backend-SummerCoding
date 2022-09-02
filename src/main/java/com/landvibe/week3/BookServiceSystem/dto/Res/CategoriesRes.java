package com.landvibe.week3.BookServiceSystem.dto.Res;

import com.landvibe.week3.BookServiceSystem.entity.Category;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesRes {

    private Integer size;
    private List<Category> categories;

}
