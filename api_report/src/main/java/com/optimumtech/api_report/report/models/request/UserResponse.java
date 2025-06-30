package com.optimumtech.api_report.report.models.request;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponse {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String telefono;
    private String rol;
    private Date fechaCreacion;
    private boolean activo;

}

