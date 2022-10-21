package com.landvibe.summer.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "seller_id")
    private String sellerId;
    private String description;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    public void mappingCategory(Category category) {
        this.category = category;
    }
}