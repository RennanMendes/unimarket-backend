package com.unimarket.unimarket.core.cases.product;

import com.unimarket.unimarket.core.entities.category.Category;
import com.unimarket.unimarket.core.entities.product.Product;

import java.util.List;

public interface FindProductByCategoryUseCase {

    List<Product> find(Category category);

}
