package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityAlreadyInUseException;
import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Cuisine;
import com.gabriel.springrestspecialist.domain.repository.CuisineRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CuisineService {
    private final CuisineRepository cuisineRepository;

    public Cuisine findById(UUID id) {
        return cuisineRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Cuisine '%s' not found", id)));
    }

    @Transactional
    public void deleteById(UUID id) {
        var cuisine = findById(id);
        try {
            cuisineRepository.deleteById(cuisine.getId());
            cuisineRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntityAlreadyInUseException("Cannot delete cuisine because it is being used by another entity");
        }
    }
}