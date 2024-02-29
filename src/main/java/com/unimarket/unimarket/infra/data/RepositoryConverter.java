package com.unimarket.unimarket.infra.data;

public interface RepositoryConverter<T, P> {

    default T mapToTable(final P persistenceObject) {
        throw new UnsupportedOperationException();
    }

    default P mapToEntity(final T tableObject) {
        throw new UnsupportedOperationException();
    }
}
