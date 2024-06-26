package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.entity.User;
import ru.shendo.flashcards.repository.UserRepository;

@Repository
@Transactional
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

}
