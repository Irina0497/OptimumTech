package com.example.api_educational.models.requests;

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

    private int idCourse;
}
