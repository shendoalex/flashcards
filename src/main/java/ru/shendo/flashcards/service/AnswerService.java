package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import ru.shendo.flashcards.entity.Answer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AnswerService {
    List<Answer> getList();

    Optional<Answer> getOne(Long id);

    List<Answer> getMany(Collection<Long> ids);

    Answer create(Answer dto);

    Answer patch(Answer id, JsonNode patchNode);

    void delete(Answer id);

}
