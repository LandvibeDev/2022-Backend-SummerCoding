package com.landvibe.summer.mvc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductExceptDescriptionResponse {
    private Long id;
    private Long categoryId;
    private String categoryName;
    private String name;
    private LocalDateTime createdAt;
}
