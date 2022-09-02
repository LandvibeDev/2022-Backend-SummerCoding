package com.landvibe.summer.reservation.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@Table(name = "category")
public class Category {
    private String cateName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK값 자동 증가
    private Long cateId;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public int size() {
        return products.size();
    }
}
