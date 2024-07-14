package ru.shendo.flashcards.service;

import ru.shendo.flashcards.dto.AnswerDto;

import java.util.List;

public interface AnswerService {

    AnswerDto createAnswer(AnswerDto answerDto);

    AnswerDto findAnswerById(Long employeeId);

    List<AnswerDto> findAllAnswers();

    AnswerDto updateAnswer(Long answerId, AnswerDto updatedAnswerDto);

    void deleteAnswer(Long AnswerId);

}
