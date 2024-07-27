package ru.shendo.flashcards.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
    public List<AnswerDto> getList() {
        List<Answer> answers = answerService.getList();
        List<AnswerDto> answerDtos = answers.stream()
                .map(answerMapper::toDto)
                .toList();
        return answerDtos;
    }

    @GetMapping("/{id}")
    public AnswerDto getOne(@PathVariable Long id) {
        Optional<Answer> answerOptional = answerService.getOne(id);
        AnswerDto answerDto = answerMapper
                .toDto(answerOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Ответ с id `%s` не найден".formatted(id))));
        return answerDto;
    }

    @GetMapping("/by-ids")
    public List<AnswerDto> getMany(@RequestParam List<Long> ids) {
        List<Answer> answers = answerService.getMany(ids);
        List<AnswerDto> answerDtos = answers.stream()
                .map(answerMapper::toDto)
                .toList();
        return answerDtos;
    }

    @PostMapping
    public AnswerDto create(@RequestBody AnswerDto dto) {
        Answer answer = answerMapper.toEntity(dto);
        Answer resultAnswer = answerService.create(answer);
        return answerMapper.toDto(resultAnswer);
    }

    @PatchMapping("/{id}")
    public AnswerDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Answer answer = answerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Ответ с id `%s` не найден".formatted(id)));

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
