package com.landvibe.week3.BookServiceSystem.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ColumnDefault("0")
    private Integer count;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    @OneToMany(mappedBy = "category")
    private List<ProductDetail> productDetailList;

}
