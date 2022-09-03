package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class GetProductsRes {
    private Integer size;
    private List<ProductsRes> products;
}