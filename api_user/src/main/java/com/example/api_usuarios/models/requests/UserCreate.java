package com.example.api_usuarios.models.requests;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.List;

@Data
public class UserCreate {

    private String nombre;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String telefono;

    private List<String> roles;

    public List<String> getRoles() {
    return roles;
}

}
