package com.example.api_usuarios.models.requests;

import lombok.Data;
import java.util.List;

@Autowired
@Data
public class UserUpdate {
    private int id;
    private String nombre;
    private String telefono;
    private String password;
    private Boolean activo;
    private List<String> roles;
    public List<String> getRoles() {
        return roles;
}
}
