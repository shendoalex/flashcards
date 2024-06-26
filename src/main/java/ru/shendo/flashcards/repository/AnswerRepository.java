package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
