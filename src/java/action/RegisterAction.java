/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import user.UserDAO;
import userdetails.UserDetailsDAO;

/**
 *
 * @author Administrator
 */
public class RegisterAction {
    private String email;
    private String password;
    private String name;
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public RegisterAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        
        UserDAO userDAO = new UserDAO();
        boolean isCreated = userDAO.createAccount(email, password);
        if(isCreated){
            UserDetailsDAO detailDAO = new UserDetailsDAO();
            boolean isInserted = detailDAO.insertEmailAndFullName(email, name);
            if(isInserted){
                url = SUCCESS;
            }
        }
        return url;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
