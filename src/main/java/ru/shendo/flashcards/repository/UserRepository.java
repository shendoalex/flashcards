package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
