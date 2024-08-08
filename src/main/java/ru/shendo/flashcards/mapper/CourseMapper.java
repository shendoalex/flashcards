package ru.shendo.flashcards.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import ru.shendo.flashcards.dto.CourseDto;
import ru.shendo.flashcards.entity.Course;
import ru.shendo.flashcards.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
    @Mapping(source = "courseOwnerId", target = "courseOwner.id")
    Course toEntity(CourseDto courseDto);

    @Mapping(source = "courseOwner.id", target = "courseOwnerId")
    CourseDto toDto(Course course);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "courseOwnerId", target = "courseOwner")
    Course partialUpdate(CourseDto courseDto, @MappingTarget Course course);

    default User createUser(Long courseOwnerId) {
        if (courseOwnerId == null) {
            return null;
        }
        User user = new User();
        user.setId(courseOwnerId);
        return user;
    }

    @InheritConfiguration(name = "partialUpdate")
    Course updateWithNull(CourseDto courseDto, @MappingTarget Course course);
}