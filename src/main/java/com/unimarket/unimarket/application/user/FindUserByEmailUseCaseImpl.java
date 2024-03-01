package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.application.exception.UserNotFoundException;
import com.unimarket.unimarket.core.cases.user.FindUserByEmailUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByEmailUseCaseImpl implements FindUserByEmailUseCase {

    private final UserRepositoryService repository;

    @Autowired
    public FindUserByEmailUseCaseImpl(UserRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public User find(String email) {
        if (repository.doesTheUserExist(email)){
            throw new UserNotFoundException();
        }
        return this.repository.findByUserByEmail(email);
    }
}
