package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.application.exception.ProductNotFoundException;
import com.unimarket.unimarket.core.cases.product.DeleteProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepositoryService repository;

    @Autowired
    public DeleteProductUseCaseImpl(ProductRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public void delete(String productCode) {
        if (!repository.doesProductExists(productCode)) {
            throw new ProductNotFoundException();
        }

        this.repository.delete(productCode);
    }
}
