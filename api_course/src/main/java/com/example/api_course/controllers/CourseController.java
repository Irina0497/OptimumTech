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
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/course")
public class CourseController {
   
    @Autowired
    private CourseService courseService;

    @GetMapping()
    @Operation(
        summary = "Obtiene todos los cursos",
        description = "Recupera una lista completa de todos los cursos disponibles en el sistema."
    )
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    @Operation(
        summary = "Obtiene un curso por ID",
        description = "Recupera los detalles de un curso específico utilizando su ID."
    )
    public Course ListOne(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("")
    @Operation(
        summary = "Crea un nuevo curso",
        description = "Permite crear un nuevo curso en el sistema con los datos proporcionados."
    )
    public Course createCourse(@Valid @RequestBody CourseCreate body) {
        return courseService.createCourse(body);
    }

    @DeleteMapping("/{id}")
    @Operation(
        summary = "Elimina un curso por ID",
        description = "Elimina un curso del sistema utilizando su ID."
    )
    public String deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return "Curso eliminado";
    }

    @PutMapping()
    @Operation(
        summary = "Actualiza un curso existente",
        description = "Permite actualizar la información de un curso existente con los nuevos datos proporcionados."
    )
    public Course updateCourse(@Valid @RequestBody CourseCreate body) {
        return courseService.updateCourse(body);
    }
}
