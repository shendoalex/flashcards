package ru.shendo.flashcards.dto;

import java.io.Serializable;

public record CourseDto(String courseName, Long courseOwnerId) {
}