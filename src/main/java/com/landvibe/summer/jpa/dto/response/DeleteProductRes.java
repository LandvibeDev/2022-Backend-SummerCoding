package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DeleteProductRes {
    private Integer code;
    private Long id;
    private String SellerId;
}