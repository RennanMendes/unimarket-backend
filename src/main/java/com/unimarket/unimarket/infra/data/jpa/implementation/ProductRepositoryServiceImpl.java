package com.unimarket.unimarket.infra.data.jpa.implementation;

import com.unimarket.unimarket.adapters.ProductRepositoryService;
import com.unimarket.unimarket.core.entities.product.Product;
import com.unimarket.unimarket.infra.data.jpa.converters.ProductRepositoryConverter;
import com.unimarket.unimarket.infra.data.jpa.entity.ProductEntity;
import com.unimarket.unimarket.infra.data.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductRepositoryServiceImpl implements ProductRepositoryService {

    private final ProductRepository repository;
    private final ProductRepositoryConverter converter;

    @Autowired
    public ProductRepositoryServiceImpl(ProductRepository repository, ProductRepositoryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = converter.mapToTable(product);
        return converter.mapToEntity(this.repository.save(entity));
    }

    @Override
    public boolean doesProductExists(String productCode) {
        return this.repository.existsByProductCodeIgnoreCase(productCode);
    }

    @Override
    public void delete(String productCode) {
        ProductEntity entity = converter.mapToTable(findByProductCode(productCode));
        this.repository.delete(entity);
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll().stream().map(product -> converter.mapToEntity(product)).collect(Collectors.toList());
    }

    @Override
    public Product findByProductCode(String productCode) {
        return converter.mapToEntity(this.repository.findByProductCode(productCode));
    }

    @Override
    public List<Product> findByKeyword(String keyword) {
        return this.repository.searchByKeyword(keyword).stream().map(product -> converter.mapToEntity(product)).collect(Collectors.toList());
    }
}
