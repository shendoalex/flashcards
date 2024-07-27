package ru.shendo.flashcards.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.shendo.flashcards.dto.QuestionDto;
import ru.shendo.flashcards.entity.Course;
import ru.shendo.flashcards.entity.Question;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {
    @Mapping(source = "courseId", target = "course.id")
    Question toEntity(QuestionDto questionDto);

    @Mapping(source = "course.id", target = "courseId")
    QuestionDto toDto(Question question);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "courseId", target = "course")
    Question partialUpdate(QuestionDto questionDto, @MappingTarget Question question);

    default Course createCourse(Long courseId) {
        if (courseId == null) {
            return null;
        }
        Course course = new Course();
        course.setId(courseId);
        return course;
    }

    @InheritConfiguration(name = "partialUpdate")
    Question updateWithNull(QuestionDto questionDto, @MappingTarget Question question);
}