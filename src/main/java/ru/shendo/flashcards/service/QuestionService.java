package ru.shendo.flashcards.service;

import ru.shendo.flashcards.dto.QuestionDto;

import java.util.List;

public interface QuestionService {

    QuestionDto createQuestion(QuestionDto questionDto);

    QuestionDto findQuestionById(Long questionId);

    List<QuestionDto> findAllQuestions();

    QuestionDto updateQuestion(Long questionId, QuestionDto questionDto);

    void deleteQuestion(Long questionId);

}
