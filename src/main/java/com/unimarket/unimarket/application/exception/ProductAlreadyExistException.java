package com.unimarket.unimarket.application.exception;

public class ProductAlreadyExistException extends RuntimeException {

    public ProductAlreadyExistException() {
            super("Product already registered!");
    }
}
