package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostCommonRes {
    private Integer code;
    private Result result;

    @Builder
    @Getter
    public static class Result {
        private Long id;
    }
}