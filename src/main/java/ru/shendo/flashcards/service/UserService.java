package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import ru.shendo.flashcards.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getList();

    Optional<User> getOne(Long id);

    List<User> getMany(Collection<Long> ids);

    User create(User dto);

    User patch(User id, JsonNode patchNode);

    void delete(User id);

}
