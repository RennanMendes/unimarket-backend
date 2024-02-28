package com.unimarket.unimarket.core.cases.user;

import com.unimarket.unimarket.core.entities.user.User;

public interface FindUserByEmailUseCase {
    User find(String email);
}
