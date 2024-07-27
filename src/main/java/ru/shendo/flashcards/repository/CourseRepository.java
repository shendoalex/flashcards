package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shendo.flashcards.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
}