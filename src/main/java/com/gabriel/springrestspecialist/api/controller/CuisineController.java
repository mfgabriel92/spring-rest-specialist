package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.repository.CuisineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/cuisines")
@RequiredArgsConstructor
public class CuisineController {
    private final CuisineRepository cuisineRepository;

    @GetMapping
    public ResponseEntity<List<Cuisine>> findAll() {
        return ok(cuisineRepository.findAll());
    }
}
