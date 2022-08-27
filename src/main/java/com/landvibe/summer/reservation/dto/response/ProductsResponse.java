package com.landvibe.summer.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductsResponse {
    private Integer size;
    private List<Products> products;
}
