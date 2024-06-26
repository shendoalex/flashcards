package ru.shendo.flashcards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shendo.flashcards.entity.Course;
import ru.shendo.flashcards.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/id")
    public Course findById() {
        return courseService.findById(1L);
    }

}
