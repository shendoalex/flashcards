package ru.shendo.flashcards.dto;


public record QuestionDto(String questionText, boolean questionCompleted, Long courseId) {
}