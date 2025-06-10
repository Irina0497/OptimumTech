package com.example.api_usuarios.config;

import com.example.api_usuarios.models.entities.Role;
import com.example.api_usuarios.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RoleInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        List<String> roles = Arrays.asList("ADMIN", "SUPPORT", "STUDENT", "TEACHER");
        for (String name : roles) {
            if (roleRepository.findByName(name) == null) {
                Role role = new Role();
                role.setName(name);
                roleRepository.save(role);
            }
        }
    }
}