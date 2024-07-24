package ru.shendo.flashcards.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shendo.flashcards.dto.QuestionDto;
import ru.shendo.flashcards.entity.QuestionEntity;
import ru.shendo.flashcards.repository.QuestionRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    public final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public QuestionEntity findById(Long id) {

        return null;


    }

    @Override
    public QuestionDto createQuestion(QuestionDto questionDto) {
        return null;
    }

    @Override
    public QuestionDto findQuestionById(Long questionId) {
        return null;
    }

    @Override
    public List<QuestionDto> findAllQuestions() {
        return List.of();
    }

    @Override
    public QuestionDto updateQuestion(Long questionId, QuestionDto questionDto) {
        return null;
    }

    @Override
    public void deleteQuestion(Long questionId) {

    }
}
