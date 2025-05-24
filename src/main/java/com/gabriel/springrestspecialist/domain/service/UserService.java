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
    public User save(User user) {
        if (!user.passwordsMatch()) {
            throw new BusinessLogicException("Passwords do not match");
        }

        var group = groupService.findByName(DEFAULT_USER_GROUP);
        user.getGroups().add(group);
        return userRepository.saveAndFlush(user);
    }
}
