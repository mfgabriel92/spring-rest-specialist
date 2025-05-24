package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Group;
import com.gabriel.springrestspecialist.domain.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group findByName(String name) {
        return groupRepository.findByName(name).orElseThrow(() ->
            new EntityNotFoundException(String.format("Group '%s' not found", name)));
    }
}
