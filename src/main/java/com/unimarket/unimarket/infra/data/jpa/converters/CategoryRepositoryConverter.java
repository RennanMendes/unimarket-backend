package com.unimarket.unimarket.infra.data.jpa.converters;

import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.RepositoryConverter;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryRepositoryConverter implements RepositoryConverter<CategoryEntity, Category> {

    @Override
    public CategoryEntity mapToTable(Category persistenceObject) {
        return new CategoryEntity(persistenceObject.getId(), persistenceObject.getCategoryName());
    }

    @Override
    public Category mapToEntity(CategoryEntity entityObject) {
        return new Category(entityObject.getId(), entityObject.getCategoryName());
    }
}
