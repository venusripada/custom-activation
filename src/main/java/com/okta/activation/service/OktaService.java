/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okta.activation.service;

import com.okta.activation.config.YAMLConfiguration;

import model.OktaPasswordRequest;
import model.OktaSecurityQuestionRequest;
import model.SecurityQuestionResponse;
import model.TokenRequest;
import model.TokenResponse;
import model.ValidateTokenRequest;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

/**
 *
 * @author venu
 */
@Service
public class OktaService {
    
    
    private YAMLConfiguration config;
    
    private WebClient client;
    
    @Autowired
    public OktaService(YAMLConfiguration config){
       this.config = config;
       client =  WebClient.create(config.getOktaBaseUrl());
 
    }
    
    public Mono<TokenResponse> validateToken(ValidateTokenRequest token) {

        Mono<TokenResponse> response = client.post()
                .uri("/api/v1/authn/recovery/token")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(token), ValidateTokenRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);

        return response;

    }
    
    public Mono<TokenResponse> authenticateToken(TokenRequest token) {

        Mono<TokenResponse> response = client.post()
                .uri("/api/v1/authn")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(token), TokenRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);

        return response;

    }

    public Mono<TokenResponse> setPassword(OktaPasswordRequest passwordRequest) {

        Mono<TokenResponse> response = client.post()
                .uri("/api/v1/authn/credentials/reset_password")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(passwordRequest), OktaPasswordRequest.class)
                .retrieve()
                .bodyToMono(TokenResponse.class);

        return response;

    }

    public Mono<SecurityQuestionResponse> setRecoveryQuestion(String userId, OktaSecurityQuestionRequest securityQuestionRequest) {

        Mono<SecurityQuestionResponse> response = client.put()
                .uri(String.format("/api/v1/users/%s", userId))
                .accept(MediaType.APPLICATION_JSON)
                .header("Authorization", String.format("SSWS %s", config.getOktaAPIKey()))
                .body(Mono.just(securityQuestionRequest), OktaSecurityQuestionRequest.class)
                .retrieve()
                .bodyToMono(SecurityQuestionResponse.class);

        return response;

    }
}
