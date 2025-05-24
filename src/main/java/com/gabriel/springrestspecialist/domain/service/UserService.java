package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.User;
import com.gabriel.springrestspecialist.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String DEFAULT_USER_GROUP = "user";
    private final UserRepository userRepository;
    private final GroupService groupService;

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("User '%s' not found", id)));
    }

    @Transactional
    public void changePassword(UUID id, String currentPassword, String password) {
        var user = findById(id);

        if (!user.isPasswordCorrect(currentPassword)) {
            throw new BusinessLogicException("Incorrect password");
        }

        user.setPassword(password);
    }

    @Transactional
    public User save(User user) {
        var group = groupService.findByName(DEFAULT_USER_GROUP);
        user.getGroups().add(group);
        return userRepository.saveAndFlush(user);
    }
}
