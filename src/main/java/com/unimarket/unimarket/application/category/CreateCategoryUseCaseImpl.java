package com.unimarket.unimarket.application.category;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.cases.category.CreateCategoryUseCase;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {

    private final CategoryRepositoryService categoryRepositoryService;

    @Autowired
    public CreateCategoryUseCaseImpl(CategoryRepositoryService categoryRepositoryService) {
        this.categoryRepositoryService = categoryRepositoryService;
    }

    @Override
    public CategoryEntity create(Category category) {
        return categoryRepositoryService.save(category);
    }
}
