package com.example.api_educational.controllers;

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

import com.example.api_educational.models.entities.Content;
import com.example.api_educational.models.requests.ContentCreate;
import com.example.api_educational.models.requests.ContentModify;
import com.example.api_educational.services.ContentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Content")
public class ContentController {
    @Autowired
    private ContentService contentService;


    @GetMapping("")
    public List<Content> listAll(){
        return contentService.getAll();
    }

    @PostMapping("")
    public Content createNew(@Valid @RequestBody ContentCreate cuerpo){
        return contentService.createNew(cuerpo);
    }

    @DeleteMapping("/{id}")
    public String deleteContent(@PathVariable int id){
        contentService.delete(id);
        return "Ok";
    }

    @PutMapping("")
    public Content modify(@RequestBody ContentModify body){
        return contentService.modify(body);
    }
}
