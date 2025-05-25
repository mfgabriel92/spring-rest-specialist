package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.BusinessLogicException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.User;
import com.gabriel.springrestspecialist.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String DEFAULT_USER_GROUP = "user";
    private final UserRepository userRepository;
    private final GroupService groupService;
    private final EntityManager entityManager;

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("User '%s' not found", id)));
    }

    @Transactional
    public User create(User user) {
        validateEmailIsUnique(user);

        var group = groupService.findByName(DEFAULT_USER_GROUP);
        user.getGroups().add(group);
        return userRepository.save(user);
    }

    @Transactional
    public User update(User user) {
        entityManager.detach(user);
        validateEmailIsUnique(user);
        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(UUID id, String currentPassword, String password) {
        var user = findById(id);

        if (!user.isPasswordCorrect(currentPassword)) {
            throw new BusinessLogicException("Incorrect password");
        }

        user.setPassword(password);
    }

    private void validateEmailIsUnique(User user) {
        var currentUser = userRepository.findByEmail(user.getEmail());

        if (currentUser.isPresent() && !currentUser.get().equals(user)) {
            throw new BusinessLogicException(String.format("An user with the email '%s' already exists", user.getEmail()));
        }
    }
}
