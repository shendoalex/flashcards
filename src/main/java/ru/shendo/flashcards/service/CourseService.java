package ru.shendo.flashcards.service;

import ru.shendo.flashcards.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto createCourse(CourseDto courseDto);

    CourseDto findCourseById(Long courseId);

    List<CourseDto> findAllCourses();

    CourseDto updateCourse(Long courseId, CourseDto courseDto);

    void deleteCourse(Long courseId);

}
