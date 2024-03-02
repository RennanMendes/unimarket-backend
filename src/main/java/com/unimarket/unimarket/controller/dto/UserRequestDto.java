package com.unimarket.unimarket.controller.dto;

import com.unimarket.unimarket.core.entities.user.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDto(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password,
        @NotNull
        Address address
) {
}
