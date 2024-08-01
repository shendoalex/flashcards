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
import ru.shendo.flashcards.dto.QuestionDto;
import ru.shendo.flashcards.entity.Question;
import ru.shendo.flashcards.mapper.QuestionMapper;
import ru.shendo.flashcards.repository.QuestionRepository;
import ru.shendo.flashcards.service.QuestionService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    private final QuestionMapper questionMapper;

    private final QuestionRepository questionRepository;

    private final ObjectMapper objectMapper;

    @GetMapping
    public List<QuestionDto> getList() {
        List<Question> questions = questionService.getList();
        List<QuestionDto> questionDtos = questions.stream()
                .map(questionMapper::toDto)
                .toList();
        return questionDtos;
    }

    @GetMapping("/{id}")
    public QuestionDto getOne(@PathVariable Long id) {
        Optional<Question> questionOptional = questionService.getOne(id);
        QuestionDto questionDto = questionMapper.toDto(questionOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Вопрос с id `%s` не найден".formatted(id))));
        return questionDto;
    }

    @GetMapping("/by-ids")
    public List<QuestionDto> getMany(@RequestParam List<Long> ids) {
        List<Question> questions = questionService.getMany(ids);
        List<QuestionDto> questionDtos = questions.stream()
                .map(questionMapper::toDto)
                .toList();
        return questionDtos;
    }

    @PostMapping
    public QuestionDto create(@RequestBody QuestionDto dto) {
        Question question = questionMapper.toEntity(dto);
        Question resultQuestion = questionService.create(question);
        return questionMapper.toDto(resultQuestion);
    }

    @PatchMapping("/{id}")
    public QuestionDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Question question = questionRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Вопрос с id `%s` не найден".formatted(id)));

        QuestionDto questionDto = questionMapper.toDto(question);
        objectMapper.readerForUpdating(questionDto).readValue(patchNode);
        questionMapper.updateWithNull(questionDto, question);

        Question resultQuestion = questionService.patch(question, patchNode);
        return questionMapper.toDto(resultQuestion);
    }

    @DeleteMapping("/{id}")
    public QuestionDto delete(@PathVariable Long id) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question != null) {
            questionService.delete(question);
        }
        return questionMapper.toDto(question);
    }

}
