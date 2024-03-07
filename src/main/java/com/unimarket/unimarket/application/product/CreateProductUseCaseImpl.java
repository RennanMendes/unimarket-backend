package com.unimarket.unimarket.application.product;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.application.category.FindCategoryById;
import com.unimarket.unimarket.application.exception.ProductAlreadyExistException;
import com.unimarket.unimarket.core.cases.product.CreateProductUseCase;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryService repository;
    private final FindCategoryById findCategoryById;

    @Autowired
    public CreateProductUseCaseImpl(ProductRepositoryService repository, FindCategoryById findCategoryById) {
        this.repository = repository;
        this.findCategoryById = findCategoryById;
    }

    @Override
    public Product create(Product product, Long categoryId) {
        if (repository.doesProductExists(product.getProductCode())) {
            throw new ProductAlreadyExistException();
        }

        product.setCategory(this.findCategoryById.findById(categoryId));
        return repository.save(product);
    }
}
