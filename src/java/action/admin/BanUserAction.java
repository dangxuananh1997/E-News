/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import user.UserDAO;

/**
 *
 * @author dangxuananh1997
 */
public class BanUserAction {
    
    //Inputs
    private String userID;
    private int pageNumber = 1;     //Display 10 articles in this page | Default: 1
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public BanUserAction() {
    }
    
    public String execute() throws Exception {

        UserDAO dao = new UserDAO();
        dao.banUser(userID);
        
        return SUCCESS;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    
}
