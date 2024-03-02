package com.unimarket.unimarket.controller.converter;

import com.unimarket.unimarket.controller.dto.UserRequestDto;
import com.unimarket.unimarket.controller.dto.UserResponseDto;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserCreateDtoConverter implements RestConverter<User, UserRequestDto, UserResponseDto> {

    @Override
    public User dtoToEntity(UserRequestDto requestDto) {

        return new User(null, requestDto.firstName(), requestDto.lastName(), requestDto.email(),
                requestDto.password(), requestDto.address(), null, null);
    }

    @Override
    public UserResponseDto entityToDto(User user) {
        return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress());
    }
}
