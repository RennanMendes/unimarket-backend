package com.unimarket.unimarket.adapters;

import com.unimarket.unimarket.core.entities.user.User;

public interface UserRepositoryService {
    User save(User user);

    boolean doesTheUserExist(String email);

    User findByEmailAndIsActiveTrue(String email);

    User edit(User user);
}
