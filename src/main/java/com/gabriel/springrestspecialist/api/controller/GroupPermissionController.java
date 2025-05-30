package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.domain.service.GroupPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping("api/v1/groups/{groupId}/permissions")
@RequiredArgsConstructor
public class GroupPermissionController {
    private final GroupPermissionService groupPermissionService;

    @PutMapping("{permissionId}")
    private ResponseEntity<Void> addPermission(@PathVariable UUID groupId, @PathVariable UUID permissionId) {
        groupPermissionService.addPermission(groupId, permissionId);
        return noContent().build();
    }

    @DeleteMapping("{permissionId}")
    private ResponseEntity<Void> removePermission(@PathVariable UUID groupId, @PathVariable UUID permissionId) {
        groupPermissionService.removePermission(groupId, permissionId);
        return noContent().build();
    }
}
