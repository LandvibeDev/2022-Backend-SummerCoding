package com.landvibe.week3.BookServiceSystem.dto.Req;

import com.landvibe.week3.BookServiceSystem.entity.Category;

import lombok.*;

import java.util.ArrayList;
import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesReq {

    private Integer size;
    private Category categories;
}
