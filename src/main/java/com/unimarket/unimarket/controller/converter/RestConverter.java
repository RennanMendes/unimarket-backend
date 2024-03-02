package com.unimarket.unimarket.controller.converter;

public interface RestConverter<A, B, C> {

    default A dtoToEntity(B persistenceObject) {
        throw new UnsupportedOperationException();
    }

    default C entityToDto(A tableObject) {
        throw new UnsupportedOperationException();
    }
}
