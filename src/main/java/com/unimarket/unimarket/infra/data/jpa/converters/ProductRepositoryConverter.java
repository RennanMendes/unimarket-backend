package com.unimarket.unimarket.infra.data.jpa.converters;

import com.unimarket.unimarket.core.entities.product.Product;
import com.unimarket.unimarket.infra.data.RepositoryConverter;
import com.unimarket.unimarket.infra.data.jpa.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepositoryConverter implements RepositoryConverter<ProductEntity, Product> {


    private final CategoryRepositoryConverter categoryConverter;

    @Autowired
    public ProductRepositoryConverter(CategoryRepositoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Override
    public ProductEntity mapToTable(Product product) {
        return new ProductEntity(product.getId(), product.getProductCode(), product.getName(), product.getPrice(),
                product.getDescription(), product.getAmount(), product.getImage(), categoryConverter.mapToTable(product.getCategory()));
    }

    @Override
    public Product mapToEntity(ProductEntity entity) {
        return new Product(entity.getId(), entity.getProductCode(), entity.getName(), entity.getPrice(),
                entity.getDescription(), entity.getAmount(), entity.getImage(), categoryConverter.mapToEntity(entity.getCategory()));
    }
}
