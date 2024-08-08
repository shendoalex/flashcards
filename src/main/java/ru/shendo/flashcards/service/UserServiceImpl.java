package ru.shendo.flashcards.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.shendo.flashcards.entity.User;
import ru.shendo.flashcards.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getMany(Collection<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public User create(User dto) {
        return userRepository.save(dto);
    }

    @Override
    public User patch(User id, JsonNode patchNode) {
        return userRepository.save(id);
    }

    @Override
    public void delete(User id) {
        userRepository.delete(id);
    }

    @Override
    public Page<User> getList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
