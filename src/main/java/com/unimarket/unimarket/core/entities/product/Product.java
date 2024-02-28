package com.unimarket.unimarket.core.entities.product;

import com.unimarket.unimarket.core.entities.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    private String name;
    private String price;
    private String description;
    private String amount;
    private String image;
    private Category category;
}
