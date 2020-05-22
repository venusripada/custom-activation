/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author venu
 */
public class ValidateTokenRequest {
    private String recoveryToken;

    public String getRecoveryToken() {
        return recoveryToken;
    }

    public void setRecoveryToken(String recoveryToken) {
        this.recoveryToken = recoveryToken;
    }
    
    public ValidateTokenRequest( String token) {
       this.recoveryToken = token;
    }
}


    

