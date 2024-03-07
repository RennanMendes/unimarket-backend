package com.unimarket.unimarket.adapters;

import com.unimarket.unimarket.core.entities.category.Category;

import java.util.List;

public interface CategoryRepositoryService {
    List<Category> find();

    Category findByCategoryName(String categoryName);

    Category save(Category category);

    void delete(Category category);

    boolean doesCategoryNameExists(String categoryName);

    Category findById(Long id);
}
