package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shendo.flashcards.dto.QuestionDto;
import ru.shendo.flashcards.entity.QuestionEntity;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(source = "course.id", target = "courseId")
    QuestionDto questionEntityToDto(QuestionEntity questionEntity);

    @Mapping(source = "courseId", target = "course.id")
    QuestionEntity questionDtoToEntity(QuestionDto questionDto);

}
