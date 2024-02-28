package com.unimarket.unimarket.core.cases.product;

import com.unimarket.unimarket.core.entities.product.Product;

public interface FindProductByProductCodeUseCase {
    Product find(String productCode);
}
