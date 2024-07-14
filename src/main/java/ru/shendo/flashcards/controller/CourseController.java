package ru.shendo.flashcards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shendo.flashcards.entity.CourseEntity;
import ru.shendo.flashcards.service.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseServiceImpl courseServiceImpl;

    public CourseController(CourseServiceImpl courseServiceImpl) {
        this.courseServiceImpl = courseServiceImpl;
    }

    @GetMapping("/id")
    public CourseEntity findById() {
        return courseServiceImpl.findById(1L);
    }

}
