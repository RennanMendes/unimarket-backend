package com.unimarket.unimarket.infra.data.jpa.repository;

import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.infra.data.jpa.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategoryNameIgnoreCase(String categoryName);

    boolean existsByCategoryNameIgnoreCase(String categoryName);
}
