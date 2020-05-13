/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;

/**
 *
 * @author venu
 */
public class TokenResponse {
    
    private String stateToken;
    private String status;
    private String errorCode;
    private String errorSummary;
    private String recoveryType;
    private Map<Object, Object> _embedded;
    
    public TokenResponse(String errorCode, String errorSummary){
        this.errorCode = errorCode;
        this.errorSummary = errorSummary;
    }
    
    public TokenResponse(){
        
    }

    public String getErrorSummary() {
        return errorSummary;
    }

    public void setErrorSummary(String errorSummary) {
        this.errorSummary = errorSummary;
    }

    public String getError() {
        return errorCode;
    }

    public void setError(String error) {
        this.errorCode = error;
    }
    
    

    public Map<Object, Object> get_embedded() {
        return _embedded;
    }

    public void set_embedded(Map<Object, Object> _embedded) {
        this._embedded = _embedded;
    }
    
    public String getStateToken() {
        return stateToken;
    }

    public void setStateToken(String stateToken) {
        this.stateToken = stateToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecoveryType() {
        return recoveryType;
    }

    public void setRecoveryType(String recoveryType) {
        this.recoveryType = recoveryType;
    }
    
}
