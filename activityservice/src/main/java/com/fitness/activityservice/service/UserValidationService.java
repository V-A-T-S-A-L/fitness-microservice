package com.fitness.activityservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId) {
        try {
            return userServiceWebClient.get()
                    .uri("/api/users/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (WebClientResponseException e) {
            if(e.getStatusCode().equals("404")) {
                throw new RuntimeException("User Not Found: " + userId);
            } else if(e.getStatusCode().equals("400")) {
                throw new RuntimeException("Invalid Request");
            }
        }
        return false;
    }
}
