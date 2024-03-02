package com.unimarket.unimarket.infra.data.jpa.entity;

import com.unimarket.unimarket.core.entities.user.Address;
import com.unimarket.unimarket.core.entities.user.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private Boolean isActive;
}
