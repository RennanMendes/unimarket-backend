package com.unimarket.unimarket.core.entities.product;

import com.unimarket.unimarket.core.entities.category.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "productCode")
public class Product {
    private String productCode;
    private String name;
    private String price;
    private String description;
    private String amount;
    private String image;
    private Category category;
}
