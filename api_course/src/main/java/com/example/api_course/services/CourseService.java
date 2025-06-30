package com.example.api_course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_course.models.entities.Course;
import com.example.api_course.models.requests.CourseCreate;
import com.example.api_course.repositories.CourseRepository;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    public Course getCourseById(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no encontrado");
        }
        return course;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(CourseCreate request) {
        Course newCourse = new Course();
       
        newCourse.setName(request.getName());
        newCourse.setCategory(request.getCategory());
        newCourse.setLevel(request.getLevel());
        newCourse.setDescription(request.getDescription());
        return courseRepository.save(newCourse);        
    }

    public Course updateCourse(CourseCreate request) {
        Course course = getCourseById(request.getId());
        if(request.getName() != null) {
            course.setName(request.getName());
            course.setCategory(request.getCategory());
            course.setLevel(request.getLevel());
            course.setDescription(request.getDescription());
        }
        return courseRepository.save(course);
    }

    public void deleteCourse(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso no encontrado");
        }
        courseRepository.delete(course);
    }
}
