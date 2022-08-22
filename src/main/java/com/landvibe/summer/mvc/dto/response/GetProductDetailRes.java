package com.landvibe.summer.mvc.dto.response;

import com.landvibe.summer.mvc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetProductDetailRes {
    private Product product;
}