/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okta.activation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author venu
 */

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class YAMLConfiguration {
  
    private String name;
    private String environment;
    private String oktaBaseUrl;
    private String oktaAPIKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getOktaBaseUrl() {
        return oktaBaseUrl;
    }

    public void setOktaBaseUrl(String oktaBaseUrl) {
        this.oktaBaseUrl = oktaBaseUrl;
    }

    public String getOktaAPIKey() {
        return oktaAPIKey;
    }

    public void setOktaAPIKey(String oktaAPIKey) {
        this.oktaAPIKey = oktaAPIKey;
    }
 
    
 
}