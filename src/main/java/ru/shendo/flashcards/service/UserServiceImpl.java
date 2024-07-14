package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.entity.UserEntity;
import ru.shendo.flashcards.repository.UserRepository;

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

}
