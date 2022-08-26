package com.landvive.summer.mvc.dto.response;

import com.landvive.summer.mvc.dto.request.ProductRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer code;
    private ProductRequest result;
}
