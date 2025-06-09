package com.example.api_course.models.requests;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentCreate {
    
    @NotBlank
    private String title;
    
    @NotBlank
    private String description;

    @NotBlank
    @URL
    private String urlVideo;

    @NotBlank
    private LocalDateTime lastUpdated;

    private int id;


}