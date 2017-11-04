/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import user.UserDAO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class NewPasswordAction {

    //Inputs
    private String email;
    private String newPassword;
    private String error;
    //Returns
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    private final String INPUT = "input";

    public NewPasswordAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        UserDAO dao = new UserDAO();
        String currentPassword = dao.getPassword(email);
        if (currentPassword != null) {
            if (currentPassword.equals(newPassword)) {
                error = "New password cannot be the same as old password";
                url = INPUT;
            } else {
                boolean result = dao.updatePassword(email, newPassword);
                if (result) {
                    url = SUCCESS;
                }
            }
        }
        return url;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
