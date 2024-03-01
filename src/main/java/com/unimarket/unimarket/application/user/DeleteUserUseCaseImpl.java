package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.core.cases.user.DeleteUserUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryService repository;
    private final FindUserByEmailUseCaseImpl findUserByEmail;

    @Autowired
    public DeleteUserUseCaseImpl(UserRepositoryService repository, FindUserByEmailUseCaseImpl findUserByEmail) {
        this.repository = repository;
        this.findUserByEmail = findUserByEmail;
    }

    @Override
    public void delete(String email) {
        User user = this.findUserByEmail.find(email);
        user.setActive(false);
    }
}
