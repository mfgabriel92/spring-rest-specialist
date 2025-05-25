package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.PasswordRequest;
import com.gabriel.springrestspecialist.api.request.UserInfoRequest;
import com.gabriel.springrestspecialist.api.request.UserRequest;
import com.gabriel.springrestspecialist.api.response.UserResponse;
import com.gabriel.springrestspecialist.domain.model.User;
import com.gabriel.springrestspecialist.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest request) {
        var user = fromModel(request);
        var response = toModel(userService.create(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> save(@PathVariable UUID id, @Valid @RequestBody UserInfoRequest request) {
        var user = userService.findById(id);
        mapper.map(request, user);
        var response = toModel(userService.update(user));
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable UUID id, @Valid @RequestBody PasswordRequest request) {
        userService.changePassword(id, request.getCurrentPassword(), request.getPassword());
        return ResponseEntity.noContent().build();
    }

    private User fromModel(UserRequest request) {
        return mapper.map(request, User.class);
    }

    private UserResponse toModel(User user) {
        return mapper.map(user, UserResponse.class);
    }
}
