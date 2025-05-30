package com.gabriel.springrestspecialist.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupPermissionService {
    private final GroupService groupService;
    private final PermissionService permissionService;

    @Transactional
    public void addPermission(UUID groupId, UUID permissionId) {
        var group = groupService.findById(groupId);
        var permission = permissionService.findById(permissionId);
        group.addPermission(permission);
    }

    @Transactional
    public void removePermission(UUID groupId, UUID permissionId) {
        var group = groupService.findById(groupId);
        var permission = permissionService.findById(permissionId);
        group.removePermission(permission);
    }
}
