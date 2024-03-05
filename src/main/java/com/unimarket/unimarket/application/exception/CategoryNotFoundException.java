package com.unimarket.unimarket.application.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Category not found!");
    }
}
