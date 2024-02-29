package com.unimarket.unimarket.application.category;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.cases.category.FindAllCategoriesUseCase;
import com.unimarket.unimarket.core.entities.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllCategoriesUseCaseImpl implements FindAllCategoriesUseCase {

    private final CategoryRepositoryService categoryRepositoryService;

    @Autowired
    public FindAllCategoriesUseCaseImpl(CategoryRepositoryService categoryRepositoryService) {
        this.categoryRepositoryService = categoryRepositoryService;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepositoryService.find();
    }
}
