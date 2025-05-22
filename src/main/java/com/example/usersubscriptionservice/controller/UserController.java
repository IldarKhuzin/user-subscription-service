package com.example.usersubscriptionservice.controller;

import com.example.usersubscriptionservice.dto.UserDto;
import com.example.usersubscriptionservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    // Конструктор для внедрения UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Создать пользователя
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        logger.info("Создание пользователя: {}", userDto);
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Получить информацию о пользователе по id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        logger.info("Получение пользователя с id: {}", id);
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Обновить данные пользователя
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID id, @RequestBody UserDto userDto) {
        logger.info("Обновление пользователя с id: {}", id);
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    // Удалить пользователя
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        logger.info("Удаление пользователя с id: {}", id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    // для проверки работы контроллера по /users/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello, world!";
    }
}
