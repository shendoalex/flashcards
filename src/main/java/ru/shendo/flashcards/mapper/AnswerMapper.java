package ru.shendo.flashcards.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.shendo.flashcards.dto.AnswerDto;
import ru.shendo.flashcards.entity.Answer;
import ru.shendo.flashcards.entity.Question;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {
    @Mapping(source = "answerQuestionId", target = "answerQuestion.id")
    Answer toEntity(AnswerDto answerDto);

    @Mapping(source = "answerQuestion.id", target = "answerQuestionId")
    AnswerDto toDto(Answer answer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "answerQuestionId", target = "answerQuestion")
    Answer partialUpdate(AnswerDto answerDto, @MappingTarget Answer answer);

    default Question createQuestion(Long answerQuestionId) {
        if (answerQuestionId == null) {
            return null;
        }
        Question question = new Question();
        question.setId(answerQuestionId);
        return question;
    }

    @InheritConfiguration(name = "partialUpdate")
    Answer updateWithNull(AnswerDto answerDto, @MappingTarget Answer answer);
}