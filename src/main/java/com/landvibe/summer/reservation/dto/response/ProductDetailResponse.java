package com.landvibe.summer.reservation.dto.response;

import com.landvibe.summer.reservation.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDetailResponse {
    private Product product;
}
