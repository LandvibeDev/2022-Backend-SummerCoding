package com.landvibe.summer.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoriesResponse {
    private Integer size;
    private List<CategoryDetail> categories;
}
