package com.example.api_course.models.requests;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.URL;

import lombok.Data;

@Data
public class ContentModify {
    private int id;
    private String title;
    private String description;

    @URL
    private String urlVideo;

    private LocalDateTime lastUpdated;

}
