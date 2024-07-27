package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.Answer;
import ru.shendo.flashcards.repository.AnswerRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public List<Answer> getList() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> getOne(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> getMany(Collection<Long> ids) {
        return answerRepository.findAllById(ids);
    }

    @Override
    public Answer create(Answer dto) {
        return answerRepository.save(dto);
    }

    @Override
    public Answer patch(Answer id, JsonNode patchNode) {
        return answerRepository.save(id);
    }

    @Override
    public void delete(Answer id) {
        answerRepository.delete(id);
    }

}
