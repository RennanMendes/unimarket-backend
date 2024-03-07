package com.unimarket.unimarket.controller.dto;

import com.unimarket.unimarket.core.entities.category.Category;

import java.math.BigDecimal;

public record ProductDto(
        Long id,
        String productCode,
        String name,
        BigDecimal price,
        String description,
        Integer amount,
        String image,
        Category category
) {

}
