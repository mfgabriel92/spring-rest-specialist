package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Group;
import com.gabriel.springrestspecialist.domain.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final PermissionService permissionService;

    public Group findById(UUID id) {
        return groupRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Group '%s' not found", id)));
    }

    public Group findByName(String name) {
        return groupRepository.findByName(name).orElseThrow(() ->
            new EntityNotFoundException(String.format("Group '%s' not found", name)));
    }

    @Transactional
    public void addPermission(UUID groupId, UUID permissionId) {
        var group = findById(groupId);
        var permission = permissionService.findById(permissionId);
        group.addPermission(permission);
    }

    @Transactional
    public void removePermission(UUID groupId, UUID permissionId) {
        var group = findById(groupId);
        var permission = permissionService.findById(permissionId);
        group.removePermission(permission);
    }
}
