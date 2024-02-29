package com.unimarket.unimarket.application.category;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.cases.category.DeleteCategoryUseCase;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {

    private final CategoryRepositoryService categoryRepositoryService;

    @Autowired
    public DeleteCategoryUseCaseImpl(CategoryRepositoryService categoryRepositoryService) {
        this.categoryRepositoryService = categoryRepositoryService;
    }

    @Override
    public void delete(String categoryName) {
        Category category = categoryRepositoryService.findByCategoryName(categoryName);
        categoryRepositoryService.delete(category);
    }
}
