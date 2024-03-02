package com.unimarket.unimarket.infra.data.jpa.converters;

import com.unimarket.unimarket.core.entities.user.User;
import com.unimarket.unimarket.infra.data.RepositoryConverter;
import com.unimarket.unimarket.infra.data.jpa.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryConverter implements RepositoryConverter<UserEntity, User> {

    @Override
    public UserEntity mapToTable(User user) {
        return new UserEntity(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getAddress(), user.getUserType(), user.getIsActive());
    }

    @Override
    public User mapToEntity(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getEmail(),
                userEntity.getPassword(), userEntity.getAddress(), userEntity.getUserType(), userEntity.getIsActive());
    }
}
