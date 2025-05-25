package com.example.api_course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_course.models.entities.Content;
import com.example.api_course.models.requests.ContentCreate;
import com.example.api_course.models.requests.ContentModify;
import com.example.api_course.services.ContentService;

@RestController
@RequestMapping("/content")
public class ContentController {
    
    @Autowired
    private ContentService contentService;

    @GetMapping("")
    public List<Content> getAllContents() {
        return contentService.getAllContents();
    }

    @PostMapping("")
    public Content createContent(@RequestBody ContentCreate body) {
        return contentService.createContent(body);
    }

    @DeleteMapping("/{id}")
    public String deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return "Contenido eliminado";
    }

    @PutMapping("")
    public Content updateContent(@RequestBody ContentModify body) {
        return contentService.updateContent(body);
    }
}
