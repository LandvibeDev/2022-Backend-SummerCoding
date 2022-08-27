package com.landvibe.summer.reservation.repository;

import com.landvibe.summer.reservation.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryProductRepositoryTest {
    ProductRepository repository = new MemoryProductRepository();

    //    @Test
//    public void save() {
//        //given
//        Product product = new Product(1L,"고양이","고양이공연",1L, LocalDateTime.now());
//        //when
//        repository.save(product);
//        Product savedProduct = repository.findById(product.getId()).get();
//
//        //then
//        Assertions.assertThat(product.getName()).isEqualTo(savedProduct.getName());
//    }
    @Test
    public void lookUp() {
        //given
        Product product1 = new Product(1L, "고양이1", "고양이공연", 1L, LocalDateTime.now());
        Product product2 = new Product(1L, "고양이2", "고양이공연", 2L, LocalDateTime.now());
        Product product3 = new Product(1L, "고양이3", "고양이공연", 3L, LocalDateTime.now());
        //when
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        List<Product> saveProducts = new ArrayList<>();
        saveProducts.add(product1);
        saveProducts.add(product2);
        saveProducts.add(product3);
        ArrayList<Product> products = repository.lookUp();
        //then
        Assertions.assertThat(saveProducts.equals(products));

    }
}
