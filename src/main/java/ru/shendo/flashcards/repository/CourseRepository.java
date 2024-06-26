package ru.shendo.flashcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shendo.flashcards.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
