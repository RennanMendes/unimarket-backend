package com.unimarket.unimarket.adapters;

import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepositoryService {
    List<CategoryEntity> find();
    CategoryEntity save(Category category);
    void delete(String category);
}
