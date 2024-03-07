package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.core.cases.product.FindProductByNameOrDescriptionUseCase;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductByNameOrDescriptionImpl implements FindProductByNameOrDescriptionUseCase {

    private final ProductRepositoryService repository;

    @Autowired
    public FindProductByNameOrDescriptionImpl(ProductRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> find(String keyword) {
        return repository.findByKeyword(keyword);
    }
}
