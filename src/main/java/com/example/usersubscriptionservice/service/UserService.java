package com.example.usersubscriptionservice.service;

import com.example.usersubscriptionservice.dto.UserDto;

import java.util.UUID;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(UUID id);

    UserDto updateUser(UUID id, UserDto userDto);

    void deleteUser(UUID id);
}
