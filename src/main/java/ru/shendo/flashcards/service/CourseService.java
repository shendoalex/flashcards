package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.Course;
import ru.shendo.flashcards.repository.CourseRepository;

@Service
@Transactional
public class CourseService {

    public final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).get();
    }

}
