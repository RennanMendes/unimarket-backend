package com.unimarket.unimarket.controller.converter;

import com.unimarket.unimarket.controller.dto.ProductRequestDto;
import com.unimarket.unimarket.controller.dto.ProductDto;
import com.unimarket.unimarket.controller.dto.UserDto;
import com.unimarket.unimarket.core.entities.product.Product;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.stereotype.Component;

@Component
public class CreateProductDtoConverter implements RestConverter<Product, ProductRequestDto, ProductDto> {

    @Override
    public Product dtoToEntity(ProductRequestDto requestDto) {

        return new Product(null, requestDto.productCode(), requestDto.name(), requestDto.price(),
                requestDto.description(), requestDto.amount(), requestDto.image(), null);
    }

    @Override
    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getProductCode(), product.getName(), product.getPrice(),
                product.getDescription(), product.getAmount(), product.getImage(), product.getCategory());
    }
}
