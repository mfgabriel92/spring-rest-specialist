package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.response.GroupResponse;
import com.gabriel.springrestspecialist.domain.model.Group;
import com.gabriel.springrestspecialist.domain.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@RequestMapping("api/v1/users/{id}/groups")
@RequiredArgsConstructor
public class UserGroupController {
    private final UserGroupService userGroupService;
    private final ModelMapper mapper;

    @GetMapping
    private ResponseEntity<Set<GroupResponse>> findAll(@PathVariable UUID id) {
        var groups = userGroupService.findAll(id);
        return ResponseEntity.ok(toModel(groups));
    }

    @PutMapping("{groupId}")
    private ResponseEntity<Void> addGroup(@PathVariable UUID id, @PathVariable UUID groupId) {
        userGroupService.addGroup(id, groupId);
        return noContent().build();
    }

    @DeleteMapping("{groupId}")
    private ResponseEntity<Void> removeGroup(@PathVariable UUID id, @PathVariable UUID groupId) {
        userGroupService.removeGroup(id, groupId);
        return noContent().build();
    }

    private GroupResponse toModel(Group group) {
        return mapper.map(group, GroupResponse.class);
    }

    private Set<GroupResponse> toModel(Set<Group> groups) {
        return groups.stream()
            .map(this::toModel)
            .collect(Collectors.toSet());
    }
}
