package com.example.api_usuarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.api_usuarios.services.UserService;

@SpringBootTest
public class UserServiceTests {
     
    @Autowired
    private UserService userService;

    @Test
    void probarHashear(){
        String password = "Hola123";
        String hash = userService.hashearPassword(password);
        boolean coincide = userService.comprobarPassword(password, hash);
        assertEquals(true, coincide);
        
    }
}
