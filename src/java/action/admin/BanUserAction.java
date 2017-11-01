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
    private String userEmail;
    private int pageNumber = 1;     //Display 10 articles in this page | Default: 1
    private String actionName;
    private String searchValue;
    
    //Return
    private final String SUCCESS = "success";
    
    public BanUserAction() {
    }
    
    public String execute() throws Exception {

        UserDAO dao = new UserDAO();
        dao.banUser(userEmail);
        
        return SUCCESS;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
}
