package ru.shendo.flashcards.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.shendo.flashcards.entity.AnswerEntity;
import ru.shendo.flashcards.entity.CourseEntity;

import java.util.List;

@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionDto {

    Long id;
    String question;
    boolean completed;
    List<AnswerEntity> answers;
    CourseEntity course;

}
