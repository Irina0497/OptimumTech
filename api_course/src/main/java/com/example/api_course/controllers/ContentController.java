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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/content")
public class ContentController {
    
    @Autowired
    private ContentService contentService;

    @GetMapping("")
    @Operation(
        summary = "Obtiene todos los contenidos", 
        description = "Recupera una lista completa de todos los contenidos registrados en el sistema."
    )
    public List<Content> getAllContents() {
        return contentService.getAllContents();
    }

    @PostMapping("")
    @Operation(
        summary = "Crea un nuevo contenido", 
        description = "Permite crear un nuevo contenido con los datos proporcionados."
    )
    public Content createContent(@RequestBody ContentCreate body) {
        return contentService.createContent(body);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Elimina un contenido por ID", 
        description = "Elimina un contenido existente utilizando su ID."
    )
    public String deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return "Contenido eliminado";
    }

    @PutMapping("")
    @Operation(
        summary = "Actualiza un contenido existente", 
        description = "Permite actualizar los detalles de un contenido existente con los nuevos datos proporcionados."
    )
    public Content updateContent(@RequestBody ContentModify body) {
        return contentService.updateContent(body);
    }
}
