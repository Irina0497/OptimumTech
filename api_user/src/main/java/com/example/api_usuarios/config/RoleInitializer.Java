package com.example.api_usuarios.config;

import com.example.api_usuarios.models.entities.Role;
import com.example.api_usuarios.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        List<String> roles = Arrays.asList("ADMIN", "MODERATOR", "SUPPORT", "STUDENT", "TEACHER");
        for (String nombre : roles) {
            if (roleRepository.findByNombre(nombre) == null) {
                Role role = new Role();
                role.setNombre(nombre);
                roleRepository.save(role);
            }
        }
    }
}