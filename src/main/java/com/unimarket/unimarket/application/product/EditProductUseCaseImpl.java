package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.core.cases.product.EditProductUseCase;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditProductUseCaseImpl implements EditProductUseCase {

    private final ProductRepositoryService repository;

    @Autowired
    public EditProductUseCaseImpl(ProductRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public Product edit(Product product) {
        // TODO -> editar produto

        return null;
    }
}
