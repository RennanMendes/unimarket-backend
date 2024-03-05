package com.unimarket.unimarket.core.cases.user;

import com.unimarket.unimarket.core.entities.user.User;

public interface FindUserByIdAndIsActiveUseCase {
    User find(Long id);
}
