package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shendo.flashcards.dto.QuestionDto;
import ru.shendo.flashcards.entity.QuestionEntity;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionDto questionEntityToDto(QuestionEntity questionEntity);

    QuestionEntity questionDtoToEntity(QuestionDto questionDto);

}
