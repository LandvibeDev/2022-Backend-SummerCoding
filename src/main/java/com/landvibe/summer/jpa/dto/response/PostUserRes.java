package com.landvibe.summer.jpa.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostUserRes {
    private Long id;
    private String name;
}