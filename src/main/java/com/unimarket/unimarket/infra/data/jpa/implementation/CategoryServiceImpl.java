package com.unimarket.unimarket.infra.data.jpa.implementation;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;
import com.unimarket.unimarket.infra.data.jpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryRepositoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> find() {
        return categoryRepository.findAll();
    }

    public CategoryEntity findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryNameIgnoreCase(categoryName);
    }

    @Override
    public CategoryEntity save(Category category) {
        CategoryEntity entity = new CategoryEntity(category);
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(CategoryEntity category) {
        categoryRepository.delete(category);
    }
}
