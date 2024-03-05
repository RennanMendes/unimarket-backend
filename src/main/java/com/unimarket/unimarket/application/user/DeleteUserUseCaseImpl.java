package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.core.cases.user.DeleteUserUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserRepositoryService repository;
    private final FindUserByIdAndIsActiveUseCaseImpl findUserByEmail;

    @Autowired
    public DeleteUserUseCaseImpl(UserRepositoryService repository, FindUserByIdAndIsActiveUseCaseImpl findUserByEmail) {
        this.repository = repository;
        this.findUserByEmail = findUserByEmail;
    }

    @Override
    public void delete(Long id) {
        User user = this.findUserByEmail.find(id);
        repository.save(user.setActive(false));
    }
}
