package com.unimarket.unimarket.controller;

import com.unimarket.unimarket.application.user.CreateUserUseCaseImpl;
import com.unimarket.unimarket.application.user.DeleteUserUseCaseImpl;
import com.unimarket.unimarket.application.user.FindUserByIdAndIsActiveUseCaseImpl;
import com.unimarket.unimarket.controller.converter.UserCreateDtoConverter;
import com.unimarket.unimarket.controller.dto.UserRequestDto;
import com.unimarket.unimarket.controller.dto.UserDto;
import com.unimarket.unimarket.core.cases.user.CreateUserUseCase;
import com.unimarket.unimarket.core.cases.user.DeleteUserUseCase;
import com.unimarket.unimarket.core.cases.user.EditUserUseCase;
import com.unimarket.unimarket.core.cases.user.FindUserByIdAndIsActiveUseCase;
import com.unimarket.unimarket.core.entities.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    private final FindUserByIdAndIsActiveUseCase findUserByEmailAndIsActive;
    private final CreateUserUseCase createUser;
    private final EditUserUseCase editUser;
    private final DeleteUserUseCase deleteUser;
    private final UserCreateDtoConverter dtoConverter;

    @Autowired
    public UserController(CreateUserUseCaseImpl createUser, FindUserByIdAndIsActiveUseCaseImpl findUserByEmailAndIsActiveUseCase, EditUserUseCase editUser, DeleteUserUseCaseImpl deleteUser, UserCreateDtoConverter createUserConverter) {
        this.createUser = createUser;
        this.findUserByEmailAndIsActive = findUserByEmailAndIsActiveUseCase;
        this.editUser = editUser;
        this.deleteUser = deleteUser;
        this.dtoConverter = createUserConverter;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findByEmail(@PathVariable Long id) {
        User user = findUserByEmailAndIsActive.find(id);
        return ResponseEntity.ok(new UserDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserRequestDto userRequest, UriComponentsBuilder uriBuilder) {
        User user = createUser.create(dtoConverter.dtoToEntity(userRequest));
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(dtoConverter.entityToDto(user));
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto dto) {
        User user = editUser.edit(id, dtoConverter.dtoToEntity(dto));
        return ResponseEntity.ok(dtoConverter.entityToDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.deleteUser.delete(id);
        return ResponseEntity.noContent().build();
    }
}