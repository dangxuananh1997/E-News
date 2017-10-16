/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;

/**
 *
 * @author dangxuananh1997
 */
public class UserDTO implements Serializable {
    
    private String email;
    private String password;
    private int roleID;
    private boolean isActive;

    public UserDTO(String email, String password, int roleID, boolean isActive) {
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.isActive = isActive;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "email=" + email + ", password=" + password + ", roleID=" + roleID + ", isActive=" + isActive + '}';
    }
    
}
