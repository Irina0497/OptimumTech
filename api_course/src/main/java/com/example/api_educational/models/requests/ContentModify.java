package com.example.api_educational.models.requests;

import org.hibernate.validator.constraints.URL;


import lombok.Data;

@Data
public class ContentModify {

    private int id;

    private String title;
    
    private String description;

    @URL
    private String urlVideo;
}
