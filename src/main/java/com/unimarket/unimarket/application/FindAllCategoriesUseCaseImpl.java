package com.unimarket.unimarket.application;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.cases.category.FindAllCategoriesUseCase;
import com.unimarket.unimarket.infra.entity.CategoryEntity;
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
    public List<CategoryEntity> findAll() {
        return this.categoryRepositoryService.find();
    }
}
