package com.landvive.summer.mvc.service;

import com.landvive.summer.mvc.dto.request.ProductRequest;
import com.landvive.summer.mvc.entity.Category;
import com.landvive.summer.mvc.entity.Product;
import com.landvive.summer.mvc.repository.CateRepository;
import com.landvive.summer.mvc.repository.ProRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProRepository repository;
    private final CateRepository categoryRepository;


    @Transactional
    public void save(Product product) {
        repository.save(product);
    }

    @Transactional
    public Long create(String name, String description, Category category) {
        validateProduct(name);

        Product newProduct = Product.builder()
                .name(name)
                .description(description)
                .category(category)
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(newProduct);
        categoryRepository.plusProductCount(category.getId());

        return newProduct.getId();
    }

    @Transactional
    public Long postProduct(ProductRequest request) {
        Category category = categoryRepository.getReferenceById(request.getCategoryId());
        return create(request.getName(), request.getDescription(), category);
    }

    private void validateProduct(String name) {
        repository.findByName2(name).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 상품입니다.");
        });

    }

    //name을 통해서 상품을 가져옴
    public Product findByName(String name) {
        return repository.findByName2(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
        // 만약 null이면 예외로 던지겠다

    }

    //id를 통해서 상품을 가져옴
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }

    public List<Product> getProductList() {
        return repository.findAll();
    }

}