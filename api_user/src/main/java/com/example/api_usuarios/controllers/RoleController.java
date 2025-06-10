package com.example.api_usuarios.controllers;

import com.example.api_usuarios.models.entities.Role;
import com.example.api_usuarios.repositories.RoleRepository;
import org.springframework.web.bind.annotation.*;
import lombok.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {
    private final RoleRepository roleRepository;

    @GetMapping
    public List<Role> listarRoles() {
        return roleRepository.findAll();
    }

    // Buscar rol por nombre
    @GetMapping("/name/{name}")
    public Role buscarPorNombre(@PathVariable String name) {
        return roleRepository.findByName(name);
}

    // Buscar rol por ID
    @GetMapping("/{id}")
    public Role buscarPorId(@PathVariable int id) {
        return roleRepository.findById(id).orElse(null);
    }

    // Crear un nuevo rol
    @PostMapping
    public Role crearRol(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    // Actualizar un rol existente
    @PutMapping("/{id}")
    public Role actualizarRol(@PathVariable int id, @RequestBody Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }

    // Eliminar un rol por ID
    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable int id) {
        roleRepository.deleteById(id);
    }
}