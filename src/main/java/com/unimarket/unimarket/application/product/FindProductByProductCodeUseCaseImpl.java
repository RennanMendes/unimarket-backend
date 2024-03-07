package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.application.exception.ProductNotFoundException;
import com.unimarket.unimarket.core.cases.product.FindProductByProductCodeUseCase;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindProductByProductCodeUseCaseImpl implements FindProductByProductCodeUseCase {

    private final ProductRepositoryService repository;

    @Autowired
    public FindProductByProductCodeUseCaseImpl(ProductRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public Product find(String productCode) {
        try {
            return repository.findByProductCode(productCode);
        } catch (Exception e) {
            throw new ProductNotFoundException();
        }
    }
}