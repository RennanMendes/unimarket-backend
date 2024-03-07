package com.unimarket.unimarket.application.category;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.entities.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCategoryById {

    private final CategoryRepositoryService repository;

    @Autowired
    public FindCategoryById(CategoryRepositoryService repository) {
        this.repository = repository;
    }

    public Category findById(Long id) {
        return repository.findById(id);
    }
}