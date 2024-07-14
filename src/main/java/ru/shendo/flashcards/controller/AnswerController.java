package ru.shendo.flashcards.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shendo.flashcards.dto.AnswerDto;
import ru.shendo.flashcards.service.AnswerServiceImpl;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerServiceImpl answerServiceImpl;


    // path variable применить
    @GetMapping("/id")
    public AnswerDto findById() {
        return answerServiceImpl.findById(1L);
    }

}
