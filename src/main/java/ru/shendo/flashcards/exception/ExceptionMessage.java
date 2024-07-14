package ru.shendo.flashcards.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    ANSWER_NOT_EXIST("answer does not exist"),
    QUESTION_NOT_EXIST("question does not exist"),
    COURSE_NOT_EXIST("course does not exist"),
    USER_NOT_EXIST("user does not exist");

    private final String textMessage;

    ExceptionMessage(String textMessage) {
        this.textMessage = textMessage;
    }

}