package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
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
        return repository.findByProductCode(productCode);
    }
}
