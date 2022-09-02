package com.landvibe.week3.BookServiceSystem.dto.Res;

import com.landvibe.week3.BookServiceSystem.entity.Product;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRes {

    private Integer size;
    private List<Product> products;

}
