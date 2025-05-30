package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.model.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGroupService {
    private final UserService userService;
    private final GroupService groupService;

    public Set<Group> findAll(UUID id) {
        var user = userService.findById(id);
        return user.getGroups();
    }

    @Transactional
    public void addGroup(UUID id, UUID groupId) {
        var user = userService.findById(id);
        var group = groupService.findById(groupId);
        user.addGroup(group);
    }

    @Transactional
    public void removeGroup(UUID id, UUID groupId) {
        var user = userService.findById(id);
        var group = groupService.findById(groupId);
        user.removeGroup(group);
    }
}
