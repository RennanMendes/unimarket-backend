package com.unimarket.unimarket.core.exception;

public class CategoryAlreadyExistException extends RuntimeException {

    public CategoryAlreadyExistException() {
        super("Category already exist!");
    }
}
