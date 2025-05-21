package com.example.api_educational.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.api_educational.models.entities.Content;
import com.example.api_educational.models.entities.Course;
import com.example.api_educational.models.requests.ContentCreate;
import com.example.api_educational.models.requests.ContentModify;
import com.example.api_educational.repositories.ContentRepository;
import com.example.api_educational.repositories.CourseRepository;

@Service
public class ContentService {
    
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public List<Content> getAll(){
        return contentRepository.findAll();
    }

    public Content getForId(int id){
        Content content =  contentRepository.findById(id).orElse(null);
        if(content == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contenido no encontrado");
        }
        return content;
    }

    public Content createNew(ContentCreate request){
        Content nue = new Content();

        nue.setDescription(request.getDescription());
        nue.setTitle(request.getTitle());
        nue.setUrlVideo(request.getUrlVideo());
        
        Course associatedCourse = courseRepository.findById(request.getIdCourse()).orElse(null);

        nue.setCourse(associatedCourse);
        return contentRepository.save(nue);
    }

    public void delete(int id){
        Content content = getForId(id);
        contentRepository.delete(content);
    }

    public Content modify(ContentModify request){
        Content content = getForId(request.getId());

        if(request.getTitle() != null){
            content.setTitle(request.getTitle());
        }
        if(request.getDescription() != null){
            content.setDescription(request.getDescription());
        }
        if(request.getUrlVideo() != null){
            content.setUrlVideo(request.getUrlVideo());
        }

        return contentRepository.save(content);
    }
}
