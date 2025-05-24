package com.optimumtech.api_payment.services;

import com.optimumtech.api_payment.models.requests.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserClient {

    private final WebClient webClient;

    public UserClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081/usuario/").build();
    }

    public Mono<UserResponse> getUserById(String id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(UserResponse.class);
    }
}