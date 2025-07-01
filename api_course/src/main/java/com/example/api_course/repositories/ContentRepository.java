package com.example.api_course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_course.models.entities.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    
} 
