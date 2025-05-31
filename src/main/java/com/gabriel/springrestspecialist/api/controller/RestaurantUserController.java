package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.IdRequest;
import com.gabriel.springrestspecialist.api.response.UserResponse;
import com.gabriel.springrestspecialist.domain.model.User;
import com.gabriel.springrestspecialist.domain.service.RestaurantUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/restaurants/{id}/managers")
@RequiredArgsConstructor
public class RestaurantUserController {
    private final RestaurantUserService restaurantUserService;
    private final ModelMapper mapper;

    @GetMapping
    private ResponseEntity<List<UserResponse>> getUsersByRestaurantId(@PathVariable UUID id) {
        var users = restaurantUserService.getUsersByRestaurantId(id);
        return ok().body(toModel(users));
    }

    @PostMapping
    private ResponseEntity<Void> addManager(@PathVariable UUID id, @Valid @RequestBody IdRequest request) {
        restaurantUserService.addUser(id, request.getId());
        return noContent().build();
    }

    @DeleteMapping
    private ResponseEntity<Void> removeManager(@PathVariable UUID id, @Valid @RequestBody IdRequest request) {
        restaurantUserService.removeUser(id, request.getId());
        return noContent().build();
    }

    private UserResponse toModel(User user) {
        return mapper.map(user, UserResponse.class);
    }

    private List<UserResponse> toModel(List<User> users) {
        return users.stream()
            .map(this::toModel)
            .toList();
    }
}
