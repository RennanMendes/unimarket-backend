package com.unimarket.unimarket.application.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Product not found!");
    }
}
