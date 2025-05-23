package com.gabriel.springrestspecialist.api.controller;

import com.gabriel.springrestspecialist.api.request.CuisineRequest;
import com.gabriel.springrestspecialist.api.response.CuisineResponse;
import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.repository.CuisineRepository;
import com.gabriel.springrestspecialist.domain.service.CuisineService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CuisineResponse>> findAll() {
        var cuisines = cuisineRepository.findAll();
        return ok(toModel(cuisines));
    }

    @GetMapping("{id}")
    public ResponseEntity<CuisineResponse> findById(@PathVariable UUID id) {
        var cuisine = cuisineService.findById(id);
        return ok(toModel(cuisine));
    }

    @PostMapping
    public ResponseEntity<CuisineResponse> save(@Valid @RequestBody CuisineRequest request) {
        var cuisine = fromModel(request);
        var response = toModel(cuisineRepository.save(cuisine));
        return ResponseEntity.status(CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<CuisineResponse> save(@PathVariable UUID id, @Valid @RequestBody CuisineRequest cuisine) {
        var current = cuisineService.findById(id);
        BeanUtils.copyProperties(cuisine, current);

        var response = toModel(cuisineRepository.save(current));
        return ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        cuisineService.deleteById(id);
        return noContent().build();
    }

    private Cuisine fromModel(CuisineRequest request) {
        return mapper.map(request, Cuisine.class);
    }

    private CuisineResponse toModel(Cuisine cuisine) {
        return mapper.map(cuisine, CuisineResponse.class);
    }

    private List<CuisineResponse> toModel(List<Cuisine> cuisines) {
        return cuisines.stream()
            .map(this::toModel)
            .toList();
    }
}
