package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.UserRequest;
import com.gabriel.springrestspecialist.api.response.UserResponse;
import com.gabriel.springrestspecialist.domain.model.User;
import com.gabriel.springrestspecialist.domain.repository.UserRepository;
import com.gabriel.springrestspecialist.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final ModelMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest request) {
        var user = fromModel(request);
        var response = toModel(userService.save(user));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    private User fromModel(UserRequest request) {
        return mapper.map(request, User.class);
    }

    private UserResponse toModel(User user) {
        return mapper.map(user, UserResponse.class);
    }
}
