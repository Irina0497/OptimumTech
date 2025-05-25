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

import com.example.api_course.models.entities.Course;
import com.example.api_course.models.requests.CourseCreate;
import com.example.api_course.services.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {
   
    @Autowired
    private CourseService courseService;

    @GetMapping()
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course ListOne( @PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("")
    public Course createCourse(@Valid @RequestBody CourseCreate body) {
        return courseService.createCourse(body);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return "Curso eliminado";
    }

    @PutMapping()
    public Course updateCourse(@Valid @RequestBody CourseCreate body) {
        return courseService.updateCourse(body);
    }
}
