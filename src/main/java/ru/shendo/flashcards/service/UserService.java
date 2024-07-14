package ru.shendo.flashcards.service;

import ru.shendo.flashcards.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto findUserById(Long userId);

    List<UserDto> findAllUsers();

    UserDto updateUser(Long userId, UserDto userDto);

    void deleteUser(Long userId);

}
