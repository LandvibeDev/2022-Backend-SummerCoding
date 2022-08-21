package com.landvibe.week3.service;

import com.landvibe.week3.dto.GetProductDetailResDto;
import com.landvibe.week3.dto.GetProductResDto;
import com.landvibe.week3.dto.PostCommonResDto;
import com.landvibe.week3.dto.PostProductReqDto;
import com.landvibe.week3.entity.Category;
import com.landvibe.week3.entity.Product;
import com.landvibe.week3.repository.CategoryRepository;
import com.landvibe.week3.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public PostCommonResDto create(PostProductReqDto reqDto) {
        Category category = validate(reqDto);

        Product product = new Product();
        product.setName(reqDto.getName());
        product.setDescription(reqDto.getDescription());
        product.setCategory(category);
        product.setCreateTime(LocalDateTime.now().withNano(0));
        category.addProduct(product);

        productRepository.save(product);

        return PostCommonResDto.builder()
                .code(0)
                .result(PostCommonResDto.Result.builder()
                        .id(product.getId())
                        .build())
                .build();
    }

    private Category validate(PostProductReqDto reqDto) {
        if (reqDto.getName()== null)
            throw new IllegalArgumentException("Name Cannot Be Null");

        if (productRepository.existName(reqDto.getName()))
            throw new IllegalArgumentException("Already Exist Name");

        Optional<Category> category = categoryRepository.findById(reqDto.getCategoryId());
        if (category.isEmpty())
            throw new IllegalStateException("Cannot Find Category");

        return category.get();
    }

    public GetProductDetailResDto getDetail(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) throw new IllegalStateException("Cannot Find Product");

        return GetProductDetailResDto.builder()
                .product(new GetProductDetailResDto.Product(product.get()))
                .build();
    }

    public GetProductResDto getAll() {
        List<Product> products = productRepository.getAll();

        GetProductResDto resDto = GetProductResDto.builder()
                .size(products.size())
                .products(new ArrayList<>())
                .build();

        products.forEach(resDto::convert);

        return resDto;
    }
}
