package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.application.exception.ProductAlreadyExistException;
import com.unimarket.unimarket.core.cases.product.CreateProductUseCase;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryService repository;

    @Autowired
    public CreateProductUseCaseImpl(ProductRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public Product create(Product product) {
        if (repository.doesProductExists(product.getProductCode())) {
            throw new ProductAlreadyExistException();
        }

        return repository.save(product);
    }
}
