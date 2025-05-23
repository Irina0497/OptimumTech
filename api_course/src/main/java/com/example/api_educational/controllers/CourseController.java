package com.example.api_educational.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_educational.models.entities.Course;
import com.example.api_educational.models.requests.CourseCreate;
import com.example.api_educational.models.requests.CourseModify;
import com.example.api_educational.services.CourseService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RequestMapping("/curso") // url:puerto/curso
@RestController
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course> all(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course listOne(@PathVariable int id){
        return courseService.getForId(id);
    }


    @PostMapping("")
    public Course createNew(@Valid @RequestBody CourseCreate body){
        return courseService.createNew(body);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        courseService.delete(id);
        return "ok";
    }
    @PutMapping()
    public Course actualizar(@Valid @RequestBody CourseModify body){
        return courseService.actualizar(body);
    }
}
