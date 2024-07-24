package ru.shendo.flashcards.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.shendo.flashcards.entity.QuestionEntity;

@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerDto {

    Long id;
    String answer;
    Integer answerOrder;
    QuestionEntity question;

}
