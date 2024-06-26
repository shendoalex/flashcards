package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.Card;
import ru.shendo.flashcards.repository.CardRepository;

@Service
@Transactional
public class CardService {

    public final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).get();
    }

}
