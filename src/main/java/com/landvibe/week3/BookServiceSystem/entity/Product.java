package com.landvibe.week3.BookServiceSystem.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long categoryId;
    private String name;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category", insertable = false, updatable = false)
    private Category category;

}
