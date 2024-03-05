package com.unimarket.unimarket.application.user;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.core.cases.user.EditUserUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditUserUseCaseImpl implements EditUserUseCase {

    private final UserRepositoryService repository;
    private final FindUserByIdAndIsActiveUseCaseImpl findUserByEmail;

    @Autowired
    public EditUserUseCaseImpl(UserRepositoryService repository, FindUserByIdAndIsActiveUseCaseImpl findUserByEmail) {
        this.repository = repository;
        this.findUserByEmail = findUserByEmail;
    }

    @Override
    public User edit(Long id, User userDto) {
        User user = this.findUserByEmail.find(id).update(userDto);
        return this.repository.save(user);
    }
}
