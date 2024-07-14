package ru.shendo.flashcards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shendo.flashcards.entity.QuestionEntity;
import ru.shendo.flashcards.service.QuestionServiceImpl;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionServiceImpl questionServiceImpl;

    public QuestionController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @GetMapping("/id")
    public QuestionEntity findById() {
        return questionServiceImpl.findById(1L);
    }

}
