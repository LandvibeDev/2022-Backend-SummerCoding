package com.landvibe.summer.jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoriesRes {
    private Integer size;
    private List<CategoryRes> categories;
}