package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shendo.flashcards.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}