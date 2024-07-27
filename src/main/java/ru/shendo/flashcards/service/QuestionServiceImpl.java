package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.Question;
import ru.shendo.flashcards.repository.QuestionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getList() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> getOne(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getMany(Collection<Long> ids) {
        return questionRepository.findAllById(ids);
    }

    @Override
    public Question create(Question dto) {
        return questionRepository.save(dto);
    }

    @Override
    public Question patch(Question id, JsonNode patchNode) {
        return questionRepository.save(id);
    }

    @Override
    public void delete(Question id) {
        questionRepository.delete(id);
    }

}
