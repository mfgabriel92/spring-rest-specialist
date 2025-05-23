package com.gabriel.springrestspecialist.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.springrestspecialist.core.validation.Groups;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cuisines")
@Getter
@Setter
public class Cuisine {
    @NotNull(groups = Groups.CuisineId.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "cuisine")
    private List<Restaurant> restaurants = new ArrayList<>();
}
