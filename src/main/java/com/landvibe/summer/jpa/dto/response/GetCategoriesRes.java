package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetCategoriesRes {
    private Integer size;
    private List<CategoryRes> categories;
}