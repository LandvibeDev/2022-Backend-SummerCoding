package com.landvibe.summer.reservation.dto.response;

import com.landvibe.summer.reservation.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {
    private Integer code;
    private Result result;

    public CategoryResponse(Integer code) {
        this.code = code;
    }
}

