package com.unimarket.unimarket.application.category;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.application.exception.CategoryNotFoundException;
import com.unimarket.unimarket.core.cases.category.DeleteCategoryUseCase;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.core.exception.CategoryAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {

    private final CategoryRepositoryService repository;

    @Autowired
    public DeleteCategoryUseCaseImpl(CategoryRepositoryService categoryRepositoryService) {
        this.repository = categoryRepositoryService;
    }

    @Override
    public void delete(String categoryName) {
        if (!repository.doesCategoryNameExists(categoryName)) {
            throw new CategoryNotFoundException();
        }

        Category category = repository.findByCategoryName(categoryName);
        repository.delete(category);
    }
}
