package com.landvibe.week3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostCommonResDto {

    private Integer code;
    private Result result;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Result {
        private Long id;
    }
}
