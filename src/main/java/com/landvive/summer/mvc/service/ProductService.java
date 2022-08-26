package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.CategoryRequest;
import com.landvive.summer.mvc.dto.request.ProductRequest;
import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;
import com.landvive.summer.mvc.repository.CategoryRepository;
import com.landvive.summer.mvc.repository.ProductRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public Long create(ProductRequest request) {
        validateProduct(request);

        Product newProduct = Product.builder()
                .id(null)
                .categoryId(request.getCategoryId())
                .name(request.getName())
                .description(request.getDescription())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(newProduct);
        categoryRepository.plusProductCount(request.getCategoryId());

        return newProduct.getId();
    }

    private void validateProduct(ProductRequest request) {
        repository.findByName(request.getName()).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 상품입니다.");
        });

    }

    //name을 통해서 상품을 가져옴
    public Product findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
        // 만약 null이면 예외로 던지겠다

    }

    //id를 통해서 상품을 가져옴
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

}
