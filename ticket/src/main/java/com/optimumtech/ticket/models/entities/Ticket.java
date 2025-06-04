package com.optimumtech.ticket.models.entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;
    
}
