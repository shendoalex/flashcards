package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<Answer> getList(Pageable pageable);
}
