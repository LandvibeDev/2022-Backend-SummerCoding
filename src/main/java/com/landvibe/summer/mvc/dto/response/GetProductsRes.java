package com.landvibe.summer.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductsRes {
    private Integer size;
    private List<ProductInfoExceptDescription> products;
}