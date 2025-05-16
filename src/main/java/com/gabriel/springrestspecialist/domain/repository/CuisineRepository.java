package com.gabriel.springrestspecialist.domain.repository;

import com.gabriel.springrestspecialist.domain.model.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, UUID> {
}
