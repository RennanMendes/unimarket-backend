package com.unimarket.unimarket.core.cases.category;

import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;

public interface CreateCategoryUseCase {
    CategoryEntity create(Category category);
}
