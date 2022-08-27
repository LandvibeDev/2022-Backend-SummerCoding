package com.landvibe.week3.BookServiceSystem.dto.Res;

import lombok.*;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRes {

    private Integer code;
    private Map<String, Long> result;

}
