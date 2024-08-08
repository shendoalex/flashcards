package ru.shendo.flashcards.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.shendo.flashcards.dto.AnswerDto;
import ru.shendo.flashcards.entity.Answer;
import ru.shendo.flashcards.mapper.AnswerMapper;
import ru.shendo.flashcards.repository.AnswerRepository;
import ru.shendo.flashcards.service.AnswerService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper answerMapper;
    private final AnswerRepository answerRepository;
    private final ObjectMapper objectMapper;

    @GetMapping
    public Page<AnswerDto> getList(
            @RequestParam(required = false) List<Long> ids,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Answer> answers;
        if (ids == null || ids.isEmpty()) {
            answers = answerService.getList(pageable);
        } else {
            List<Answer> answerList = answerService.getMany(ids);
            answers = new PageImpl<>(answerList, pageable, answerList.size());
        }
        return answers.map(answerMapper::toDto);
    }

    @GetMapping("/{id}")
    public AnswerDto getOne(@PathVariable Long id) {
        Answer answer = answerService.getOne(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ответ с id `%s` не найден".formatted(id)));
        return answerMapper.toDto(answer);
    }

    @PostMapping
    public AnswerDto create(@RequestBody AnswerDto dto) {
        Answer answer = answerMapper.toEntity(dto);
        Answer resultAnswer = answerService.create(answer);
        return answerMapper.toDto(resultAnswer);
    }

    @PatchMapping("/{id}")
    public AnswerDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Answer answer = answerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ответ с id `%s` не найден".formatted(id)));

        AnswerDto answerDto = answerMapper.toDto(answer);
        objectMapper.readerForUpdating(answerDto).readValue(patchNode);
        answerMapper.updateWithNull(answerDto, answer);

        Answer resultAnswer = answerService.patch(answer, patchNode);
        return answerMapper.toDto(resultAnswer);
    }

    @DeleteMapping("/{id}")
    public AnswerDto delete(@PathVariable Long id) {
        Answer answer = answerRepository.findById(id).orElse(null);
        if (answer != null) {
            answerService.delete(answer);
        }
        return answerMapper.toDto(answer);
    }
}