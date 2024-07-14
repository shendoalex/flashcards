package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.shendo.flashcards.dto.CourseDto;
import ru.shendo.flashcards.entity.CourseEntity;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "owner.id", target = "ownerId")
    CourseDto courseEntityToDto(CourseEntity courseEntity);

    @Mapping(source = "ownerId", target = "owner.id")
    CourseEntity courseDtoToEntity(CourseDto courseDto);

}
