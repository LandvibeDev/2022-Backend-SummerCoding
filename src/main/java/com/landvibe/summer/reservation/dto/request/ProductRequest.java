package com.landvibe.summer.reservation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ProductRequest {
    private Long categoryId;
    private String name;
    private String description;
    private Long id;
}
