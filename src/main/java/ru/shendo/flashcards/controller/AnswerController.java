package ru.shendo.flashcards.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shendo.flashcards.entity.Answer;
import ru.shendo.flashcards.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    public Answer findById() {
        return answerService.findById(1L);
    }

}
