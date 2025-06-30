package com.optimumtech.api_payment.services;

import com.optimumtech.api_payment.models.requests.CourseResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CourseClient {

    private final WebClient webClient;

    public CourseClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8082/course/").build();
    }

    public Mono<CourseResponse> getCourseById(String id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(CourseResponse.class);
    }
}