package com.unimarket.unimarket.core.cases.product;

import com.unimarket.unimarket.core.entities.product.Product;

import java.util.List;

public interface FindProductByNameOrDescriptionOrCategory {
    List<Product> find(String keyword);
}