package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shendo.flashcards.dto.CourseDto;
import ru.shendo.flashcards.entity.CourseEntity;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto courseEntityToDto(CourseEntity courseEntity);

    CourseEntity courseDtoToEntity(CourseDto courseDto);

}
