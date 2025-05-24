package com.example.api_course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_course.models.entities.Content;
import com.example.api_course.models.entities.Course;
import com.example.api_course.models.requests.ContentCreate;
import com.example.api_course.models.requests.ContentModify;
import com.example.api_course.repositories.ContentRepository;
import com.example.api_course.repositories.CourseRepository;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public Content getContentById(int id) {
        Content content = contentRepository.findById(id).orElse(null);
        if (content == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contenido no encontrado");
        }
        return content;
    }

    public Content createContent(ContentCreate request) {
        Content newContent = new Content();

        newContent.setTitle(request.getTitle());
        newContent.setDescription(request.getDescription());
        newContent.setUrlVideo(request.getUrlVideo());
        newContent.setLastUpdated(request.getLastUpdated());

        Course associatedCourse = courseRepository.findById(request.getId()).orElse(null);

        newContent.setCourse(associatedCourse);
        return contentRepository.save(newContent);
    }

    public Content updateContent(ContentModify request) {
        Content content = getContentById(request.getId());
        
        if(request.getTitle() != null) {
            content.setTitle(request.getTitle());
        }
        if(request.getDescription() != null) {
            content.setDescription(request.getDescription());
        }
        if(request.getUrlVideo() != null) {
            content.setUrlVideo(request.getUrlVideo());
        }
        if(request.getLastUpdated() != null) {
            content.setLastUpdated(request.getLastUpdated());
        }
        return contentRepository.save(content);
    }  
    
    public void deleteContent(int id) {
        Content content = getContentById(id);
        contentRepository.delete(content);
    }
}
