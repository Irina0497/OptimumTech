package com.example.api_course.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseModify {
    private int id;

    @NotBlank
    private String name;

     @NotBlank
    private String  category;

    @NotBlank
    private String  level;

    @NotBlank
    private String description;
}
