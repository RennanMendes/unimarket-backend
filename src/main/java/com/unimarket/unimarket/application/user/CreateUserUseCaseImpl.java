package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.core.cases.user.CreateUserUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import com.unimarket.unimarket.core.exception.UserAlreadyRegistered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserRepositoryService repository;

    @Autowired
    public CreateUserUseCaseImpl(UserRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        if (repository.doesTheUserExist(user.getEmail())){
            throw new UserAlreadyRegistered();
        }
        return this.repository.save(user);
    }
}
