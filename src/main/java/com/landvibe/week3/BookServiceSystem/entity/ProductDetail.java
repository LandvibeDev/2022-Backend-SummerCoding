package com.landvibe.week3.BookServiceSystem.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productDetail")
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_Id")
    private Long categoryId;
    @Column(name = "category_Name")
    private String categoryName;
    private String name;
    private String description;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category", insertable = false, updatable = false)
    private Category category;
}
