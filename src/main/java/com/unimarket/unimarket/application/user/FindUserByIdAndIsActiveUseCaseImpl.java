package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.application.exception.UserNotFoundException;
import com.unimarket.unimarket.core.cases.user.FindUserByIdAndIsActiveUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindUserByIdAndIsActiveUseCaseImpl implements FindUserByIdAndIsActiveUseCase {

    private final UserRepositoryService repository;

    @Autowired
    public FindUserByIdAndIsActiveUseCaseImpl(UserRepositoryService repository) {
        this.repository = repository;
    }

    @Override
    public User find(Long id) {
        if (!repository.doesTheUserExist(id)) {
            throw new UserNotFoundException();
        }
        return this.repository.findByEmailAndIsActiveTrue(id);
    }
}
