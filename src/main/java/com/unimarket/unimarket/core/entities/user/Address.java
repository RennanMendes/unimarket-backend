package com.unimarket.unimarket.core.entities.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String zipCode;
    private String complement;
}
