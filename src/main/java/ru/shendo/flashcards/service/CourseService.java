package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.shendo.flashcards.entity.Course;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getList();

    Optional<Course> getOne(Long id);

    List<Course> getMany(Collection<Long> ids);

    Course create(Course dto);

    Course patch(Course id, JsonNode patchNode);

    void delete(Course id);

    Page<Course> getList(Pageable pageable);

}
