/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.springframework.util.MultiValueMap;

/**
 *
 * @author venu
 */
public class OktaPasswordRequest {

    private String stateToken;
    private String newPassword;

    public OktaPasswordRequest(MultiValueMap<String, String> paramMap) {
        this.stateToken = paramMap.get("stateToken") != null
                ? paramMap.get("stateToken").toArray()[0].toString()
                : null;
        this.newPassword = paramMap.get("password") != null
                ? paramMap.get("password").toArray()[0].toString()
                : null;
    }

    public String getStateToken() {
        return stateToken;
    }

    public void setStateToken(String stateToken) {
        this.stateToken = stateToken;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
