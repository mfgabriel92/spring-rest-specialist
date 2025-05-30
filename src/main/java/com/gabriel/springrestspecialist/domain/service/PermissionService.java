package com.gabriel.springrestspecialist.domain.service;

import com.gabriel.springrestspecialist.domain.exception.EntityNotFoundException;
import com.gabriel.springrestspecialist.domain.model.Permission;
import com.gabriel.springrestspecialist.domain.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public Permission findById(UUID id) {
        return permissionRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException(String.format("Permission '%s' not found", id)));
    }
}
