package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shendo.flashcards.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}