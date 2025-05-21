package com.example.api_educational.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_educational.models.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    
}
