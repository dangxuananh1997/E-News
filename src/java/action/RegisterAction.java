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
    private String error;
    private final String SUCCESS = "success";
    private final String INPUT = "input";
    private final String FAIL = "fail";

    public RegisterAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;

        UserDAO userDAO = new UserDAO();
        boolean isEmailExisted = userDAO.checkEmail(email);
        if (!isEmailExisted) {
            boolean isCreated = userDAO.createAccount(email, password, 1);
            if (isCreated) {
                UserDetailsDAO detailDAO = new UserDetailsDAO();
                boolean isInserted = detailDAO.insertEmailAndFullName(email, name);
                if (isInserted) {
                    url = SUCCESS;
                }
            }
        } else {
            error = "Email already exists";
            url = INPUT;
        }
        return url;
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

}
