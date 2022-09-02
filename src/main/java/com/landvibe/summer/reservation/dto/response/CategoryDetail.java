package com.landvibe.summer.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CategoryDetail {
    Long id;
    String name;
    Integer count;
}
