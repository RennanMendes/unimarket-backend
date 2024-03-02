package com.unimarket.unimarket.infra.data.jpa.implementation;

import com.unimarket.unimarket.adapters.UserRepositoryService;
import com.unimarket.unimarket.core.entities.user.User;
import com.unimarket.unimarket.infra.data.jpa.converters.UserRepositoryConverter;
import com.unimarket.unimarket.infra.data.jpa.entity.UserEntity;
import com.unimarket.unimarket.infra.data.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository repository;
    private final UserRepositoryConverter converter;

    @Autowired
    public UserRepositoryServiceImpl(UserRepository repository, UserRepositoryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public User save(User user) {
        UserEntity entity = repository.save(this.converter.mapToTable(user));
        return this.converter.mapToEntity(entity);
    }

    @Override
    public boolean doesTheUserExist(String email) {
        return this.repository.existsByEmailAndIsActiveTrue(email);
    }

    @Override
    public User findByEmailAndIsActiveTrue(String email) {
        return this.converter.mapToEntity(this.repository.findByEmailAndIsActiveTrue(email));
    }

    @Override
    @Transactional
    public User edit(User user) {
        return this.save(user);
    }
}
