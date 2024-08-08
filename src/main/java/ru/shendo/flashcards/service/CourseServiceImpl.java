package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.Course;
import ru.shendo.flashcards.repository.CourseRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getList() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getOne(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getMany(Collection<Long> ids) {
        return courseRepository.findAllById(ids);
    }

    @Override
    public Course create(Course dto) {
        return courseRepository.save(dto);
    }

    @Override
    public Course patch(Course id, JsonNode patchNode) {
        return courseRepository.save(id);
    }

    @Override
    public void delete(Course id) {
        courseRepository.delete(id);
    }

    @Override
    public Page<Course> getList(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

}
