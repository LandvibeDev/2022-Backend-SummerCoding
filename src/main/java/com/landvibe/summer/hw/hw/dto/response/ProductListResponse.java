package com.landvibe.summer.hw.hw.dto.response;

import com.landvibe.summer.hw.hw.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class ProductListResponse {
    private Integer sz;
    private Optional<List<Product>> productList;
}
