package com.vinisnzy.api_rest_crud.service;

import com.vinisnzy.api_rest_crud.enums.RoleName;
import com.vinisnzy.api_rest_crud.model.Role;
import com.vinisnzy.api_rest_crud.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository repository;

    public Role getRoleByName(RoleName roleName) {
        Optional<Role> role = repository.findByName(roleName);

        if (role.isEmpty()) {
            Role newRole = new Role(null, roleName);
            repository.save(newRole);
            return newRole;
        }

        return role.get();
    }
}
