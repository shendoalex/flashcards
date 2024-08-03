package ru.shendo.flashcards.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.shendo.flashcards.dto.UserDto;
import ru.shendo.flashcards.entity.User;
import ru.shendo.flashcards.mapper.UserMapper;
import ru.shendo.flashcards.repository.UserRepository;
import ru.shendo.flashcards.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    private final ObjectMapper objectMapper;

    @GetMapping
    public List<UserDto> getList(@RequestParam(required = false) List<Long> ids) {
        List<User> users;
        if (ids == null || ids.isEmpty()) {
            users = userService.getList();
        } else {
            users = userService.getMany(ids);
        }
        return users.stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable Long id) {
        Optional<User> userOptional = userService.getOne(id);
        UserDto userDto = userMapper.toDto(userOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с id `%s` не найден".formatted(id))));
        return userDto;
    }

    @PatchMapping("/{id}")
    public UserDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        User user = userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Пользователь с id `%s` не найден".formatted(id)));

        UserDto userDto = userMapper.toDto(user);
        objectMapper.readerForUpdating(userDto).readValue(patchNode);
        userMapper.updateWithNull(userDto, user);

        User resultUser = userService.patch(user, patchNode);
        return userMapper.toDto(resultUser);
    }


    @DeleteMapping("/{id}")
    public UserDto delete(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userService.delete(user);
        }
        return userMapper.toDto(user);
    }

}
