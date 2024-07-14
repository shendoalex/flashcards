package ru.shendo.flashcards.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionDto {

    String question;
    private Long courseId;
    boolean completed;

}
