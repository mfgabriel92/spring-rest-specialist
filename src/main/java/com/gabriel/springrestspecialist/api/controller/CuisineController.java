package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.repository.CuisineRepository;
import com.gabriel.springrestspecialist.domain.service.CuisineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/v1/cuisines")
@RequiredArgsConstructor
public class CuisineController {
    private final CuisineRepository cuisineRepository;
    private final CuisineService cuisineService;

    @GetMapping
    public ResponseEntity<List<Cuisine>> findAll() {
        return ok(cuisineRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Cuisine> findById(@PathVariable UUID id) {
        return ok(cuisineService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cuisine> save(@RequestBody Cuisine cuisine) {
        cuisineRepository.save(cuisine);
        return ResponseEntity.status(CREATED).body(cuisine);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cuisine> save(@PathVariable UUID id, @RequestBody Cuisine cuisine) {
        var current = cuisineService.findById(id);

        BeanUtils.copyProperties(cuisine, current, "id");
        current = cuisineRepository.save(current);

        return ResponseEntity.status(CREATED).body(current);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        cuisineService.deleteById(id);
        return noContent().build();
    }
}
