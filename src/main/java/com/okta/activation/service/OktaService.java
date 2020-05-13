/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okta.activation.service;

import model.OktaPasswordRequest;
import model.OktaSecurityQuestionRequest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import model.TokenRequest;
import model.TokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 *
 * @author venu
 */
@Service
public class OktaService {
    
    private WebClient client = WebClient.create("https://venuokta.oktapreview.com");
    public Mono<TokenResponse> validateToken(TokenRequest token) {
       
       Mono<TokenResponse> response =  client.post()
                .uri("/api/v1/authn")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(token), TokenRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);
       
       return response;
                  
    }
    
    public Mono<TokenResponse> setPassword(OktaPasswordRequest passwordRequest) {
       
       Mono<TokenResponse> response =  client.post()
                .uri("/api/v1/authn/credentials/reset_password")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(passwordRequest), OktaPasswordRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);
 
       return response;
                  
    }
    
    public Mono<TokenResponse> setRecoveryQuestion(OktaSecurityQuestionRequest securityQuestionRequest) {
       
       Mono<TokenResponse> response =  client.put()
                .uri("/api/v1/authn/credentials/reset_password")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(securityQuestionRequest), OktaPasswordRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);
 
       return response;
                  
    }
}
