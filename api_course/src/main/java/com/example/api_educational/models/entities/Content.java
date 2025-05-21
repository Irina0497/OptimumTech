package com.example.api_educational.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contenido")
public class Content {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String urlVideo;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    @JsonBackReference
    private Course course;
}
