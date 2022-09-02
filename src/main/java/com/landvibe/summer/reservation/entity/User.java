package com.landvibe.summer.reservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@Builder
@Entity
@NoArgsConstructor
@Table(name = "name")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK값 자동 증가
    @Column(name = "user_id")
    private Long id;
    private String password;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")}
    )
    private Set<Authority> authorities;
}
