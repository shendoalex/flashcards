package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.CourseEntity;
import ru.shendo.flashcards.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    public final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseEntity findById(Long id) {
        return courseRepository.findById(id).get();
    }

}
