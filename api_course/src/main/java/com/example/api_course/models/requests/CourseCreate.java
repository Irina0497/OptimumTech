package com.example.api_course.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseCreate {
    
    @NotBlank
    private String name;

    @NotBlank
    private String  category;

    @NotBlank
    private String  level;

    @NotBlank
    private String description;

    private int id;

}