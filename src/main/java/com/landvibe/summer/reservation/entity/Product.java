package com.landvibe.summer.reservation.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String name;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK값 자동 증가
    private Long id;
    private LocalDateTime createdAt;
    private String register;

}
