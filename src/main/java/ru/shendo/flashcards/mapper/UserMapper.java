package ru.shendo.flashcards.mapper;

import org.mapstruct.Mapper;
import ru.shendo.flashcards.dto.UserDto;
import ru.shendo.flashcards.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto UserEntityToDto(UserEntity userEntity);

    UserEntity UserDtoToEntity(UserDto userDto);

}
