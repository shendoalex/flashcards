package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.dto.UserDto;
import ru.shendo.flashcards.entity.UserEntity;
import ru.shendo.flashcards.repository.UserRepository;

import java.util.List;

@Repository
@Transactional
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto findUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> findAllUsers() {
        return List.of();
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
