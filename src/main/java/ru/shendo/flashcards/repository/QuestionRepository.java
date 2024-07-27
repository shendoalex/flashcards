package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shendo.flashcards.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{
}