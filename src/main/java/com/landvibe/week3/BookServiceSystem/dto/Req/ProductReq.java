package com.landvibe.week3.BookServiceSystem.dto.Req;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReq {

    private Long categoryId;
    private String name;
    private String description;

}
