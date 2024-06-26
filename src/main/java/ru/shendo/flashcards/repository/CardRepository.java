package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
