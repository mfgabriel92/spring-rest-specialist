package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.response.GroupResponse;
import com.gabriel.springrestspecialist.domain.model.Group;
import com.gabriel.springrestspecialist.domain.service.GroupService;
import com.gabriel.springrestspecialist.domain.service.UserService;
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
    private final UserService userService;
    private final GroupService groupService;
    private final ModelMapper mapper;

    @GetMapping
    private ResponseEntity<Set<GroupResponse>> findAll(@PathVariable UUID id) {
        var user = userService.findById(id);
        var response = toModel(user.getGroups());
        return ResponseEntity.ok(response);
    }

    @PutMapping("{groupId}")
    private ResponseEntity<Void> addGroup(@PathVariable UUID id, @PathVariable UUID groupId) {
        userService.addGroup(id, groupId);
        return noContent().build();
    }

    @DeleteMapping("{groupId}")
    private ResponseEntity<Void> removeGroup(@PathVariable UUID id, @PathVariable UUID groupId) {
        userService.removeGroup(id, groupId);
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
