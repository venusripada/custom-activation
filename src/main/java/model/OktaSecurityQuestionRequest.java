/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;
import org.springframework.util.MultiValueMap;

/**
 *
 * @author venu
 */
public class OktaSecurityQuestionRequest {
    private Map<String, Object> credentials;
    
    public OktaSecurityQuestionRequest(MultiValueMap<String, String> paramMap){
        
        String question = paramMap.get("securityQuestion") != null
                ? paramMap.get("securityQuestion").toArray()[0].toString()
                : null;
        String answer = paramMap.get("securityQuestionAnswer") != null
                ? paramMap.get("securityQuestionAnswer").toArray()[0].toString()
                : null;
        
        Map <String, String> recoveryQuestion = new HashMap<>();
        recoveryQuestion.put("question", question);
        recoveryQuestion.put("answer", answer);
        
        this.credentials = new HashMap();
        this.credentials.put("recovery_question", recoveryQuestion);
    }

    public Map<String, Object> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, Object> credentials) {
        this.credentials = credentials;
    }
    
    
}
