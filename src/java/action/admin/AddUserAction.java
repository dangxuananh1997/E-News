/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

/**
 *
 * @author dangxuananh1997
 */
public class AddUserAction {
    
    private String email;
    private String password;
    private String name;
    private String error;
    private int roleID;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public AddUserAction() {
    }
    
    public String execute() throws Exception {
        
        
        return SUCCESS;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
}
