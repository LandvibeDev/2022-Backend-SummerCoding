package com.landvibe.week3.BookServiceSystem.dto.Res;

import lombok.*;

import java.util.Map;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRes {

    private Integer code;
    private Map<String, Long> result;

}
