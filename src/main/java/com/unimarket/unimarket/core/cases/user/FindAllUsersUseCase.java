package com.unimarket.unimarket.core.cases.user;

import com.unimarket.unimarket.core.entities.user.User;

import java.util.List;

public interface FindAllUsersUseCase {
    List<User> find();
}
