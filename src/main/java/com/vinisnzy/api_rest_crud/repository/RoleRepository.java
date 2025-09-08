package com.vinisnzy.api_rest_crud.repository;

import com.vinisnzy.api_rest_crud.enums.RoleName;
import com.vinisnzy.api_rest_crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}