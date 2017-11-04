/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import user.UserDAO;
import userdetails.UserDetailsDAO;

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
        String url = FAIL;

        UserDAO userDAO = new UserDAO();
        boolean isEmailExisted = userDAO.checkEmail(email);
        if (!isEmailExisted) {
            boolean isCreated = false;
            switch (roleID) {
                case 2:
                    isCreated = userDAO.createAccount(email, password, 2);  //create author account
                    break;
                case 3:
                    isCreated = userDAO.createAccount(email, password, 3);  //create editor account
                    break;
            }
            if (isCreated) {
                UserDetailsDAO detailDAO = new UserDetailsDAO();
                boolean isInserted = detailDAO.insertEmailAndFullName(email, name);
                if (isInserted) {
                    url = SUCCESS;
                }
            }
        } else {
            error = "Email already exists";
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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

}
