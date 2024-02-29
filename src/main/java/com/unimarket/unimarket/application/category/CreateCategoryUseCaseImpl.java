package com.unimarket.unimarket.application.category;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.cases.category.CreateCategoryUseCase;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.core.exception.CategoryAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private final CategoryRepositoryService repository;

    @Autowired
    public CreateCategoryUseCaseImpl(CategoryRepositoryService categoryRepositoryService) {
        this.repository = categoryRepositoryService;
    }

    @Override
    public Category create(Category category) {
        if (repository.doesCategoryNameExists(category.getCategoryName())) {
            throw new CategoryAlreadyExistException();
        }
        return repository.save(category);
    }
}
