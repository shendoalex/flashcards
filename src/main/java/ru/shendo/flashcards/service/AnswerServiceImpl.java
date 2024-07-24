package ru.shendo.flashcards.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shendo.flashcards.dto.AnswerDto;
import ru.shendo.flashcards.entity.AnswerEntity;
import ru.shendo.flashcards.repository.AnswerRepository;
import ru.shendo.flashcards.exception.EntityNotFoundException;
import ru.shendo.flashcards.exception.ExceptionMessage;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public AnswerDto findById(Long id) {

        AnswerEntity answerEntity = answerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionMessage.ANSWER_NOT_EXIST));

        return AnswerDto.builder()
                .answer("answer")
                .answerOrder(1)
                .build();
    }


    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        return null;
    }

    @Override
    public AnswerDto findAnswerById(Long employeeId) {
        return null;
    }

    @Override
    public List<AnswerDto> findAllAnswers() {
        return List.of();
    }

    @Override
    public AnswerDto updateAnswer(Long answerId, AnswerDto updatedAnswerDto) {
        return null;
    }

    @Override
    public void deleteAnswer(Long AnswerId) {

    }
}
