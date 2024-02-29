package com.unimarket.unimarket.core.cases.category;

import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;

import java.util.List;

public interface FindAllCategoriesUseCase {
    List<Category> findAll();
}
