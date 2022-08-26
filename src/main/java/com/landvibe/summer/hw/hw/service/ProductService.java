package com.landvibe.summer.hw.hw.service;

import com.landvibe.summer.hw.hw.dto.request.ProductRequest;
import com.landvibe.summer.hw.hw.dto.response.ProductDetailResponse;
import com.landvibe.summer.hw.hw.entity.Product;
import com.landvibe.summer.hw.hw.repository.MemoryProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final MemoryProductRepository memoryProductRepository;

    public Long register(ProductRequest request){
        validateProduct(request);

        Product newProduct = new Product(null, request.getCategoryId(), request.getName(), request.getDescription(), LocalDateTime.now());

        memoryProductRepository.save(newProduct);
        return newProduct.getId();
    }

    private Optional<Product> validateProduct(ProductRequest request) {
        Optional<Product> product = memoryProductRepository.findByName(request.getName());
        if(!product.isEmpty()){
            throw new IllegalStateException("이미 존재하는 상품입니다.");
        }
        return product;
    }

    public Product findByName(String name){
        return memoryProductRepository.findByName(name)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }

    public Product findOne(Long id){
        return memoryProductRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품입니다."));
    }

    public Integer getProductListSize(){
        return memoryProductRepository.getProductListSize();
    }

    public Optional<List<Product>> getProductList() {
        return memoryProductRepository.getProductList();
    }

    public Optional<ProductDetailResponse> getProductDetail(Long productId){
        Optional<Product> product = memoryProductRepository.findById(productId);
        if(product.isEmpty()){
            throw new IllegalStateException("존재하지 않는 상품 ID 입니다.");
        }
        return memoryProductRepository.getProductDetail(product.get());
    }
}
