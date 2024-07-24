package ru.shendo.flashcards.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.shendo.flashcards.entity.QuestionEntity;
import ru.shendo.flashcards.entity.UserEntity;

import java.util.List;

@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseDto {

    Long id;
    String name;
    UserDto owner;
    List<QuestionEntity> questions;

}
