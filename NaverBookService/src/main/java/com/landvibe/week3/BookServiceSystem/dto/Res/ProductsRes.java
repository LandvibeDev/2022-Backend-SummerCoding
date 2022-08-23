package com.landvibe.week3.BookServiceSystem.dto.Res;

import com.landvibe.week3.BookServiceSystem.entity.Product;
import lombok.*;

import java.util.ArrayList;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRes {

    private Integer size;
    private ArrayList<Product> products;

}
