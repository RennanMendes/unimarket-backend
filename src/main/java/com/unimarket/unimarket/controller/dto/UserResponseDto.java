package com.unimarket.unimarket.controller.dto;

import com.unimarket.unimarket.core.entities.user.Address;
import com.unimarket.unimarket.core.entities.user.User;

public record UserResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

    public UserResponseDto(User user) {
        this(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getAddress()
        );
    }
}
