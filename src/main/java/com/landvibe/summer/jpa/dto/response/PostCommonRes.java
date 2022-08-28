package com.landvibe.summer.jpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCommonRes {
    private Integer code;
    private Result result;

    @Getter
    @AllArgsConstructor
    public static class Result {
        private Long id;
    }
}