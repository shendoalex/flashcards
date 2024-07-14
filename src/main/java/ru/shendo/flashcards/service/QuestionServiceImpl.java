package ru.shendo.flashcards.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shendo.flashcards.entity.QuestionEntity;
import ru.shendo.flashcards.repository.QuestionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    public final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public QuestionEntity findById(Long id) {

        return null;


    }

}
