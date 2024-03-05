package com.unimarket.unimarket.core.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Address address;
    private UserType userType;
    private Boolean isActive;

    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public User setNewUser() {
        isActive = true;
        this.userType = UserType.COMMON;
        return this;
    }

    public User update(User userDto) {
        this.firstName = userDto.getFirstName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        this.address = userDto.getAddress();
        return this;
    }
}
