package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.shendo.flashcards.dto.AnswerDto;
import ru.shendo.flashcards.entity.AnswerEntity;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerEntity answerDtoToEntity(AnswerDto answerDto);

    AnswerDto answerEntityToDto(AnswerEntity answerEntity);

}

