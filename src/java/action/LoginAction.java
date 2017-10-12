/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import user.UserDAO;
import usersdetail.UsersDetailDAO;
import usersdetail.UsersDetailDTO;

/**
 *
 * @author Administrator
 */
public class LoginAction {

    private String email;
    private String password;
    private List<UsersDetailDTO> details = null;
    private final String SUCCESS_MEMBER = "successMember";
    private final String SUCCESS_AUTHOR = "successAuthor";
    private final String SUCCESS_EDITOR = "successEditor";
    private final String SUCCESS_ADMIN = "successAdmin";
    private final String FAIL = "fail";

    public LoginAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;

        UserDAO userDao = new UserDAO();
        boolean result = userDao.checkLogin(email, password);

        if (result) {

            int role = userDao.getRole(email);
            if (role == 1) {
                url = SUCCESS_MEMBER;
            }
            if (role == 2) {
                url = SUCCESS_AUTHOR;
            }
            if (role == 3) {
                url = SUCCESS_EDITOR;
            }
            if (role == 4) {
                url = SUCCESS_ADMIN;
            }

            UsersDetailDAO detailDAO = new UsersDetailDAO();
            detailDAO.getUsersDetail(email);
            details = detailDAO.getDetailsList();

            Map session = ActionContext.getContext().getSession();
            session.put("DETAILS", details);
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
