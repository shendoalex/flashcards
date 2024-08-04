package ru.shendo.flashcards.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.shendo.flashcards.dto.CourseDto;
import ru.shendo.flashcards.entity.Course;
import ru.shendo.flashcards.mapper.CourseMapper;
import ru.shendo.flashcards.repository.CourseRepository;
import ru.shendo.flashcards.service.CourseService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    private final CourseRepository courseRepository;

    private final ObjectMapper objectMapper;

    @GetMapping
    public List<CourseDto> getList(@RequestParam(required = false) List<Long> ids) {
        List<Course> courses;
        if (ids == null || ids.isEmpty()) {
            courses = courseService.getList();
        } else {
            courses = courseService.getMany(ids);
        }
        return courses.stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CourseDto getOne(@PathVariable Long id) {
        Optional<Course> courseOptional = courseService.getOne(id);
        CourseDto courseDto = courseMapper.toDto(courseOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Курс с id `%s` не найден".formatted(id))));
        return courseDto;
    }

    @PostMapping
    public CourseDto create(@RequestBody CourseDto dto) {
        Course course = courseMapper.toEntity(dto);
        Course resultCourse = courseService.create(course);
        return courseMapper.toDto(resultCourse);
    }

    @PatchMapping("/{id}")
    public CourseDto patch(@PathVariable Long id, @RequestBody JsonNode patchNode) throws IOException {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Курс с id `%s` не найден".formatted(id)));

        CourseDto courseDto = courseMapper.toDto(course);
        objectMapper.readerForUpdating(courseDto).readValue(patchNode);
        courseMapper.updateWithNull(courseDto, course);

        Course resultCourse = courseService.patch(course, patchNode);
        return courseMapper.toDto(resultCourse);
    }

    @DeleteMapping("/{id}")
    public CourseDto delete(@PathVariable Long id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            courseService.delete(course);
        }
        return courseMapper.toDto(course);
    }

}
