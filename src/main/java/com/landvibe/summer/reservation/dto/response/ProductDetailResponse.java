package com.landvibe.summer.reservation.dto.response;

import com.landvibe.summer.reservation.entity.Product;
import com.landvibe.summer.reservation.entity.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDetailResponse {
    private ProductDetail product;
}
