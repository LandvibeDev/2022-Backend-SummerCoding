package com.landvive.summer.mvc.dto.response;

import com.landvive.summer.mvc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponse {
    private Integer size;
    private List<Product> productList;
}
