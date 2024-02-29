package com.unimarket.unimarket.infra.implementation;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.entity.CategoryEntity;
import com.unimarket.unimarket.infra.repository.CategoryRepository;
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
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public CategoryEntity save(Category category) {
        CategoryEntity entity = new CategoryEntity(category);
        return categoryRepository.save(entity);
    }

    @Override
    public void delete(String category) {
        CategoryEntity categoryEntity = findByCategoryName(category);
        categoryRepository.delete(categoryEntity);
    }
}
