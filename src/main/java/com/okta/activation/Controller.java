/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okta.activation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okta.activation.service.OktaService;
import model.OktaPasswordRequest;
import model.TokenResponse;
import model.TokenRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 *
 * @author venu
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private OktaService oktaService;

    @RequestMapping("/activate/{token}")
    public String activate(Model model, @PathVariable String token) throws JsonProcessingException {

        TokenResponse response = oktaService.validateToken(
                new TokenRequest(token))
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("response", objectMapper.writeValueAsString(response));
        model.addAttribute("token", response.getStateToken());

        return "activation";
    }

    @PostMapping(
            path = "/createUser",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})

    public String createUser(Model model, @RequestParam MultiValueMap<String, String> paramMap) throws JsonProcessingException {
        //TODO validate password, security Question and answer on server side
        //TODO call reset password and use response to call Set recovery question
        /*TokenResponse response = oktaService.validateToken(
                new TokenRequest(token))
                
                .block();
        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("response", objectMapper.writeValueAsString(response));*/
        OktaPasswordRequest passwordRequest = new OktaPasswordRequest(paramMap);
        TokenResponse response = oktaService.setPassword(passwordRequest)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("response", objectMapper.writeValueAsString(response));
        model.addAttribute("stateToken", response.getStateToken());
        return "success";
    }

    @ExceptionHandler(WebClientResponseException.class)
    public String handleWebClientResponseException(WebClientResponseException ex, Model model) throws Exception {
        //logger.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(), ex.getResponseBodyAsString(), ex);
        TokenResponse response = new TokenResponse(ex.getStatusCode().toString(), ex.getResponseBodyAsString());
        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("response", objectMapper.writeValueAsString(response));

        return "error";
    }
}
