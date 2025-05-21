package com.example.api_educational.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseCreate {
    
    @NotBlank
    private String name;
}
