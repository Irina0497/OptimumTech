package com.example.api_educational.models.entities;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "course")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;


    @JsonManagedReference
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Content> content = new ArrayList<>();
}
