package ru.shendo.flashcards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shendo.flashcards.entity.Card;
import ru.shendo.flashcards.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/id")
    public Card findById() {
        return cardService.findById(1L);
    }

}
