package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shendo.flashcards.dto.AnswerDto;
import ru.shendo.flashcards.entity.AnswerEntity;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    @Mapping(source = "question.id", target = "questionId")
    AnswerDto answerEntityToDto(AnswerEntity answerEntity);

    @Mapping(source = "questionId", target = "question.id")
    AnswerEntity answerDtoToEntity(AnswerDto answerDto);

}
