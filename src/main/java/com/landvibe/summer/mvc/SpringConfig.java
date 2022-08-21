package com.landvibe.summer.mvc;

import com.landvibe.summer.mvc.repository.CategoryRepository;
import com.landvibe.summer.mvc.repository.MemoryCategoryRepository;
import com.landvibe.summer.mvc.repository.MemoryProductRepository;
import com.landvibe.summer.mvc.repository.ProductRepository;
import com.landvibe.summer.mvc.service.CategoryService;
import com.landvibe.summer.mvc.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CategoryService CategoryService() {
        return new CategoryService(categoryRepository());
    }

    @Bean
    public CategoryRepository categoryRepository() {
        return new MemoryCategoryRepository();
    }

    @Bean
    public ProductService productService() {
        return new ProductService(categoryRepository(), productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new MemoryProductRepository();
    }
}