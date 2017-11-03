/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import user.UserDAO;
import userdetails.UserDetailsDAO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author Administrator
 */
public class LoginAction {

    //Inputs
    private String email;
    private String password;

    //Outputs
    private UserDetailsDTO userDetails;

    //Return
    private final String SUCCESS_MEMBER = "successMember";
    private final String SUCCESS_AUTHOR = "successAuthor";
    private final String SUCCESS_EDITOR = "successEditor";
    private final String SUCCESS_ADMIN = "successAdmin";
    private String error;
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;

        UserDAO userDao = new UserDAO();
        boolean result = userDao.checkLogin(email, password);

        if (result) {
            boolean isActive = userDao.isActive(email);
            if (isActive) {
                int role = userDao.getRole(email);
                switch (role) {
                    case 1:
                        url = SUCCESS_MEMBER;
                        break;
                    case 2:
                        url = SUCCESS_AUTHOR;
                        break;
                    case 3:
                        url = SUCCESS_EDITOR;
                        break;
                    case 4:
                        url = SUCCESS_ADMIN;
                        break;
                }
                UserDetailsDAO detailDAO = new UserDetailsDAO();
                userDetails = detailDAO.getUserDetails(email);
                Map session = ActionContext.getContext().getSession();
                session.put("USERDETAILS", userDetails);
            } else {
                error = "Your account has been banned";
            }
        } else {
            error = "Email or password is invalid";
        }
        return url;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }

}
