package com.landvibe.summer.mvc.dto.response;

import com.landvibe.summer.mvc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {
    private Integer size;
    private List<Product> products;
}