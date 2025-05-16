package com.gabriel.springrestspecialist.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cuisines")
@Data
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cuisine")
    private List<Restaurant> restaurants = new ArrayList<>();
}
