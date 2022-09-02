package com.landvibe.summer.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class Products {
    Long id;
    Long categoryId;
    String name;
    LocalDateTime createdAt;
}
