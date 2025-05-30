package com.gabriel.springrestspecialist.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(
        name = "users_groups",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<Group> groups = new HashSet<>();

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    public boolean isSameUser(UUID id) {
        return this.id.equals(id);
    }

    public boolean isPasswordCorrect(String password) {
        return this.password.equals(password);
    }

    public void addGroup(Group group) {
        getGroups().add(group);
    }

    public void removeGroup(Group group) {
        getGroups().remove(group);
    }
}
