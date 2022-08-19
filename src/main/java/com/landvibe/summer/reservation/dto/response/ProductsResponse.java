package com.landvibe.summer.reservation.dto.response;

import com.landvibe.summer.reservation.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class ProductsResponse {
    private Integer size;
    private ArrayList<Product> products;
}
