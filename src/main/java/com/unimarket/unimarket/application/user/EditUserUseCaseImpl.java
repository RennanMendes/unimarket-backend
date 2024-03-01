package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.core.cases.user.EditUserUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EditUserUseCaseImpl implements EditUserUseCase {

    private final UserRepositoryService repository;
    private final FindUserByEmailUseCaseImpl findUserByEmail;

    @Autowired
    public EditUserUseCaseImpl(UserRepositoryService repository, FindUserByEmailUseCaseImpl findUserByEmail) {
        this.repository = repository;
        this.findUserByEmail = findUserByEmail;
    }

    @Override
    @Transactional
    public User edit(String email, User userDto) {
        User user = this.findUserByEmail.find(email);
        //TODO -> atribuir os atributos que serão auterados do dto ao user

        return user;
    }
}
