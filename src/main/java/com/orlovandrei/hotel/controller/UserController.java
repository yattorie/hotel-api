package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.user.User;
import com.orlovandrei.hotel.service.UserService;
import com.orlovandrei.hotel.dto.user.UserDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.dto.validation.OnUpdate;
import com.orlovandrei.hotel.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "User Controller", description = "User API")
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    public static final String FIND_BY_ID = "/api/v1/users/{id}";
    public static final String FIND_ALL = "/api/v1/users";
    public static final String FIND_BY_NAME = "/api/v1/users/username/{username}";
    public static final String FIND_BY_EMAIL = "/api/v1/users/email/{email}";
    public static final String CREATE = "/api/v1/users";
    public static final String UPDATE = "/api/v1/users/{id}";
    public static final String DELETE = "/api/v1/users/{id}";

    @GetMapping(FIND_BY_ID)
    @Operation(summary = "Get UserDto by id")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @GetMapping(FIND_BY_NAME)
    @Operation(summary = "Get UserDto by username")
    public UserDto getByUsername(@PathVariable String username) {
        User user = userService.getByUsername(username);
        return userMapper.toDto(user);
    }

    @GetMapping(FIND_BY_EMAIL)
    @Operation(summary = "Get UserDto by email")
    public UserDto getByEmail(@PathVariable String email) {
        User user = userService.getByEmail(email);
        return userMapper.toDto(user);
    }

    @GetMapping(FIND_ALL)
    @Operation(summary = "Get all users")
    public List<UserDto> getAll() {
        List<User> users = userService.getAll();
        return userMapper.toDto(users);
    }

    @PostMapping(CREATE)
    @Operation(summary = "Create a new user")
    public UserDto create(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PutMapping(UPDATE)
    @Operation(summary = "Update an existing user")
    public UserDto update(@PathVariable Long id, @Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(id, user);
        return userMapper.toDto(updatedUser);
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Delete user")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }
}
