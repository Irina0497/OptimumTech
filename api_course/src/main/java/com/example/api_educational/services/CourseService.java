package com.example.api_educational.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_educational.models.entities.Course;
import com.example.api_educational.models.requests.CourseCreate;
import com.example.api_educational.repositories.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;


    public Course getForId(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if(course == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no encontrado");
        }
        return course;
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course createNew(CourseCreate request){
        Course nue = new Course();
        nue.setName(request.getName());
        return courseRepository.save(nue);
    }
}
