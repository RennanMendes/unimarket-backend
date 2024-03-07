package com.unimarket.unimarket.adapters;

import com.unimarket.unimarket.core.entities.product.Product;

import java.util.List;

public interface ProductRepositoryService {
    Product save(Product product);

    boolean doesProductExists(String productCode);

    void delete(String productCode);

    List<Product> findAll();

    Product findByProductCode(String productCode);

    List<Product> findByKeyword(String keyword);
}