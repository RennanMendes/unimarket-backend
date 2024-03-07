package com.unimarket.unimarket.controller;

import com.unimarket.unimarket.controller.converter.CreateProductDtoConverter;
import com.unimarket.unimarket.controller.dto.ProductDto;
import com.unimarket.unimarket.controller.dto.ProductRequestDto;
import com.unimarket.unimarket.core.cases.product.*;
import com.unimarket.unimarket.core.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final FindAllProductsCase findAll;
    private final FindProductByProductCodeUseCase findByProductCode;
    private final FindProductByNameOrDescriptionUseCase search;
    private final CreateProductUseCase create;
    private final DeleteProductUseCase delete;
    private final CreateProductDtoConverter converter;


    @Autowired
    public ProductController(FindAllProductsCase findAll, FindProductByProductCodeUseCase findByProductCode, FindProductByNameOrDescriptionUseCase search, CreateProductUseCase create, DeleteProductUseCase delete, CreateProductDtoConverter converter) {
        this.findAll = findAll;
        this.findByProductCode = findByProductCode;
        this.search = search;
        this.create = create;
        this.delete = delete;
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<Product> products = this.findAll.findAll();
        return ResponseEntity.ok(products.stream().map(product -> converter.entityToDto(product)).collect(Collectors.toList()));
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> findByProductCode(@PathVariable String productCode) {
        Product product = this.findByProductCode.find(productCode);
        return ResponseEntity.ok(converter.entityToDto(product));
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ProductDto>> search(@PathVariable String keyword) {
        List<Product> products = this.search.find(keyword);
        return ResponseEntity.ok(products.stream().map(product -> converter.entityToDto(product)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequestDto productDto, UriComponentsBuilder uriBuilder) {
        Product response = create.create(this.converter.dtoToEntity(productDto), productDto.categoryId());
        URI uri = uriBuilder.path("/product/{productCode}").buildAndExpand(response.getProductCode()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity delete(@PathVariable String productCode){
        this.delete.delete(productCode);
        return ResponseEntity.noContent().build();
    }
}
