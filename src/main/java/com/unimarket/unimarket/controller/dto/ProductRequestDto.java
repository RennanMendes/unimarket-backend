package com.unimarket.unimarket.controller.dto;

import java.math.BigDecimal;

public record ProductRequestDto(
        String productCode,
        String name,
        BigDecimal price,
        String description,
        Integer amount,
        String image,
        Long categoryId
) {
}
