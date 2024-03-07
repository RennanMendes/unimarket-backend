package com.unimarket.unimarket.infra.data.jpa.implementation;

import com.unimarket.unimarket.adapters.CategoryRepositoryService;
import com.unimarket.unimarket.application.exception.CategoryNotFoundException;
import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.converters.CategoryRepositoryConverter;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;
import com.unimarket.unimarket.infra.data.jpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryRepositoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryRepositoryConverter categoryConverter;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryRepositoryConverter repositoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = repositoryConverter;
    }

    @Override
    public List<Category> find() {
        return categoryRepository.findAll().stream().map(category -> categoryConverter.mapToEntity(category)).collect(Collectors.toList());
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryRepository.save(categoryConverter.mapToTable(category));
        return categoryConverter.mapToEntity(categoryEntity);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(categoryConverter.mapToTable(category));
    }

    @Override
    public boolean doesCategoryNameExists(String categoryName) {
        return categoryRepository.existsByCategoryNameIgnoreCase(categoryName);
    }

    @Override
    public Category findById(Long id) {
        CategoryEntity entity = categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
        return categoryConverter.mapToEntity(entity);
    }

    public Category findByCategoryName(String categoryName) {
        CategoryEntity category = categoryRepository.findByCategoryNameIgnoreCase(categoryName);
        return categoryConverter.mapToEntity(category);
    }

}