package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shendo.flashcards.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
}