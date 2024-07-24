package ru.shendo.flashcards.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.dto.CourseDto;
import ru.shendo.flashcards.entity.CourseEntity;
import ru.shendo.flashcards.repository.CourseRepository;

import java.util.List;

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

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        return null;
    }

    @Override
    public CourseDto findCourseById(Long courseId) {
        return null;
    }

    @Override
    public List<CourseDto> findAllCourses() {
        return List.of();
    }

    @Override
    public CourseDto updateCourse(Long courseId, CourseDto courseDto) {
        return null;
    }

    @Override
    public void deleteCourse(Long courseId) {

    }
}
