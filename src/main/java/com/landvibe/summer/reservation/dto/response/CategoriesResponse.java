package com.landvibe.summer.reservation.dto.response;

import com.landvibe.summer.reservation.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class CategoriesResponse {
    private Integer size;
    private ArrayList<Category> categories;
}
