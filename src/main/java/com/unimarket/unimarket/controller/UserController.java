package com.unimarket.unimarket.controller;

import com.unimarket.unimarket.application.user.CreateUserUseCaseImpl;
import com.unimarket.unimarket.application.user.DeleteUserUseCaseImpl;
import com.unimarket.unimarket.application.user.FindUserByEmailAndIsActiveUseCaseImpl;
import com.unimarket.unimarket.controller.converter.UserCreateDtoConverter;
import com.unimarket.unimarket.controller.dto.UserRequestDto;
import com.unimarket.unimarket.controller.dto.UserResponseDto;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserUseCaseImpl createUser;
    private final FindUserByEmailAndIsActiveUseCaseImpl findUserByEmailAndIsActive;
    private final DeleteUserUseCaseImpl deleteUser;
    private final UserCreateDtoConverter createUserConverter;

    @Autowired
    public UserController(CreateUserUseCaseImpl createUser, FindUserByEmailAndIsActiveUseCaseImpl findUserByEmailAndIsActiveUseCase, DeleteUserUseCaseImpl deleteUser, UserCreateDtoConverter createUserConverter) {
        this.createUser = createUser;
        this.findUserByEmailAndIsActive = findUserByEmailAndIsActiveUseCase;
        this.deleteUser = deleteUser;
        this.createUserConverter = createUserConverter;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email) {
        User user = findUserByEmailAndIsActive.find(email);
        return ResponseEntity.ok(new UserResponseDto(user));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequest, UriComponentsBuilder uriBuilder) {
        User user = createUser.create(createUserConverter.dtoToEntity(userRequest));
        URI uri = uriBuilder.path("/user/{email}").buildAndExpand(user.getEmail()).toUri();
        return ResponseEntity.created(uri).body(createUserConverter.entityToDto(user));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity delete(@PathVariable String email){
        this.deleteUser.delete(email);
        return ResponseEntity.noContent().build();
    }

}
