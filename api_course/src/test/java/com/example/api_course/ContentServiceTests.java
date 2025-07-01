package com.example.api_course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.api_course.models.entities.Course;
import com.example.api_course.models.entities.Content;
import com.example.api_course.models.requests.ContentCreate;
import com.example.api_course.repositories.CourseRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.api_course.services.ContentService;

@SpringBootTest
public class ContentServiceTests {
     
    @Autowired
    private ContentService contentService;
    
    @Autowired
    private CourseRepository courseRepository;

    @Test
    void probarGetAllContents() {
        assertNotNull(contentService.getAllContents());
    }

    @Test
    void probarInsertarYListarContenido() {
        // Crear y guardar un curso base
        Course curso = new Course();
        curso.setName("Curso Test");
        curso.setCategory("Test");
        curso.setLevel("Básico");
        curso.setDescription("Curso de prueba");
        curso = courseRepository.save(curso);

        // Crear el request de contenido
        ContentCreate request = new ContentCreate();
        request.setTitle("Título de prueba");
        request.setDescription("Descripción de prueba");
        request.setUrlVideo("http://test.com/video");
        request.setId(curso.getId());

        // Insertar el contenido
        contentService.createContent(request);

        // Verificar que aparece en la lista
        List<Content> lista = contentService.getAllContents();
        boolean existe = lista.stream().anyMatch(c -> c.getTitle().equals("Título de prueba"));
        assertEquals(true, existe);
    }
}