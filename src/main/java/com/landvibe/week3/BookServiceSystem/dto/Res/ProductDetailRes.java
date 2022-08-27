package com.landvibe.week3.BookServiceSystem.dto.Res;

import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;
import lombok.*;

import java.util.Map;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailRes {
    Map<String, ProductDetail> product;
}
