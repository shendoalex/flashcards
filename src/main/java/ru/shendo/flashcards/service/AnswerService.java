package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.Answer;
import ru.shendo.flashcards.repository.AnswerRepository;

@Service
@Transactional
public class AnswerService {

    public final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer findById(Long id) {
        return answerRepository.findById(id).get();
    }

}
