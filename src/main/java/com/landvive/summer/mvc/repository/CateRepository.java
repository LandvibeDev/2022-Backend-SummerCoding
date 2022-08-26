package com.landvive.summer.mvc.repository;

import com.landvive.summer.mvc.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CateRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c FROM Category c WHERE c.name = :name")
    Optional<Category> findByName2(String name);

    @Modifying
    @Query("UPDATE Category c SET c.count = c.count+1 WHERE c.id = :categoryId")
    void plusProductCount(Long categoryId);

}