/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author venu
 */
public class OktaSecurityQuestionRequest {
    private Map<String, Object> credentials;
    
    public OktaSecurityQuestionRequest(String question, String answer){
        Map <String, String> recoveryQuestion = new HashMap<>();
        recoveryQuestion.put("question", question);
        recoveryQuestion.put("answer", answer);
        
        credentials.put("recovery_question", recoveryQuestion);
    }

    public Map<String, Object> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, Object> credentials) {
        this.credentials = credentials;
    }
    
    
}
