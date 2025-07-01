package com.example.api_course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.api_course.models.entities.Course;
import com.example.api_course.repositories.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseServiceTests {
    
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void probarEliminarCurso() {
        // Crear y guardar un curso base
        Course curso = new Course();
        curso.setName("Curso para eliminar");
        curso.setCategory("Test");
        curso.setLevel("Básico");
        curso.setDescription("Curso de prueba para eliminar");
        curso = courseRepository.save(curso);

        // Eliminar el curso
        courseRepository.deleteById(curso.getId());

        // Verificar que ya no existe
        boolean existe = courseRepository.findById(curso.getId()).isPresent();
        assertEquals(false, existe);
    }
}
