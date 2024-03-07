package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.core.cases.product.FindAllProductsCase;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllProductsCaseImpl implements FindAllProductsCase {

    private final ProductRepositoryService repository;

    public FindAllProductsCaseImpl(ProductRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
