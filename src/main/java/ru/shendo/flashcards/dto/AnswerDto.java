package ru.shendo.flashcards.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AnswerDto {

    String answer;
    int answerOrder;
    Long questionId;

}
