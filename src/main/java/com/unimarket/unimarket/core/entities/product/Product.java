package com.unimarket.unimarket.core.entities.product;

import com.unimarket.unimarket.core.entities.category.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "productCode")
public class Product {
    private Long id;
    private String productCode;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer amount;
    private String image;
    private Category category;

    public void setCategory(Category category) {
        this.category = category;
    }
}
