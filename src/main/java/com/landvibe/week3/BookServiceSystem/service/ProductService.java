package com.landvibe.week3.BookServiceSystem.service;

import com.landvibe.week3.BookServiceSystem.dto.Req.ProductReq;
import com.landvibe.week3.BookServiceSystem.entity.Category;
import com.landvibe.week3.BookServiceSystem.entity.Product;
import com.landvibe.week3.BookServiceSystem.entity.ProductDetail;
import com.landvibe.week3.BookServiceSystem.repository.CategoryRepository;
import com.landvibe.week3.BookServiceSystem.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final ArrayList<Product> productArrayList
            = new ArrayList<>();

    public Map<Integer, Long> join(ProductReq productReq) {

        Map<Integer, Long> productCodeAndResult = new HashMap<>();

        Integer successCode = validateDuplicatedProduct(productReq);
        Map<Integer, Long> productCodeAndResult1 = IsPossiblePost(productCodeAndResult, successCode);

        if (productCodeAndResult1 != null) return productCodeAndResult1;

        Product newProduct = new Product(null, productReq.getCategoryId(),
                productReq.getName(), null);

        ProductDetail newProductDetail = new ProductDetail(null,
                productReq.getCategoryId(),
                categoryRepository.findNameByCategoryId(productReq.getCategoryId())
                , productReq.getName(),
                productReq.getDescription(), null);


        productRepository.save(newProduct);
        productRepository.saveDetail(newProductDetail);
        productArrayList.add(newProduct);
        categoryCountIncrement(newProduct);

        productCodeAndResult.put(successCode, newProduct.getId());


        return productCodeAndResult;
    }

    private Integer validateDuplicatedProduct(ProductReq productReq) {
        Optional<Product> product = productRepository.findByProductName(productReq.getName());

        if (product.isPresent())
            return -1;
        else
            return 0;
    }

    private Map<Integer, Long> IsPossiblePost(Map<Integer, Long> productCodeAndResult, Integer successCode) {
        if (successCode == -1) {
            productCodeAndResult.put(successCode, null);
            return productCodeAndResult;
        }
        return null;
    }


    public ProductDetail findById(Long id) {
        return productRepository.findByProductId(id)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 상품ID입니다."));
    }

    public void categoryCountIncrement(Product product) {

        Category category = categoryRepository.findByCategoryId(product
                        .getCategoryId())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 카테고리ID입니다."));

        category.setCount(category.getCount() + 1);

    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }

    public Integer getProductSize() {
        return productArrayList.size();
    }
}
