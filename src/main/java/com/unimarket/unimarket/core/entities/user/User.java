package com.unimarket.unimarket.core.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Address address;
    private UserType userType;
    private boolean isActive;
}
