package com.unimarket.unimarket.infra.repository;

import com.unimarket.unimarket.infra.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    CategoryEntity findByCategoryName(String categoryName);
}
