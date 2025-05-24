package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.City;
import com.gabriel.springrestspecialist.domain.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public City findById(UUID id) {
        return cityRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("City '%s' not found", id)));
    }
}