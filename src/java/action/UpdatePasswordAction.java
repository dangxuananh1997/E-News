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
public class UpdatePasswordAction {

    //input
    private String oldPassword;
    private String newPassword;
    private String email;

    //output
    private String error;

    //return
    private final String SUCCESS = "success";
    private final String INPUT = "input";
    private final String FAIL = "fail";

    public UpdatePasswordAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;

        Map session = ActionContext.getContext().getSession();
        UserDetailsDTO detailsDTO = (UserDetailsDTO) session.get("USERDETAILS");
        email = detailsDTO.getEmail();    //get email from session

        UserDAO user = new UserDAO();
        boolean isCurrentPassword = user.checkLogin(email, oldPassword);    //check if oldPassword is current password
        if (isCurrentPassword) {
            if (newPassword.equals(oldPassword)) {
                error = "New password cannot be the same as old password!";
                url = INPUT;
            }
            boolean result = user.updatePassword(email, newPassword);    //update new password
            if (result) {
                url = SUCCESS;
            }
        } else {
            error = "Old password is invalid!";
            url = INPUT;
        }
        return url;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
