package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.shendo.flashcards.entity.Question;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<Question> getList();

    Optional<Question> getOne(Long id);

    List<Question> getMany(Collection<Long> ids);

    Question create(Question dto);

    Question patch(Question id, JsonNode patchNode);

    void delete(Question id);

    Page<Question> getList(Pageable pageable);

}
