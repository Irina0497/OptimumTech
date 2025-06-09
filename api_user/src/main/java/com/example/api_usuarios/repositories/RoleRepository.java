package com.example.api_usuarios.repositories;

import com.example.api_usuarios.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByNombre(String nombre);
}