/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import java.util.ArrayList;
import role.RoleDAO;
import user.UserDAO;
import userdetails.UserDetailsDAO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewManageUserAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 10 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<UserDetailsDTO> userList;
    private ArrayList<String> roleList;
    private ArrayList<Boolean> isActive;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 5;      //Tab number
    private final String actionName = "adminViewManageUser";
    
    //Return
    private final String SUCCESS = "success";
    
    public ViewManageUserAction() {
    }
    
    public String execute() throws Exception {
        
        //list user
        UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
        RoleDAO roleDAO = new RoleDAO();
        UserDAO userDAO = new UserDAO();
        
        userList = new ArrayList<>();
        roleList = new ArrayList<>();
        isActive = new ArrayList<>();
        
        ArrayList<UserDetailsDTO> tempUserList = userDetailsDAO.viewAllUsers();
        if (tempUserList == null)
            tempUserList = new ArrayList<>();
        else {
            for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < tempUserList.size(); i++) {
                this.userList.add(tempUserList.get(i));
            }

            //list role
            for (int i = 0; i < 10 && i < userList.size(); i++) {
                roleList.add(roleDAO.getRoleName(userList.get(i).getEmail()));
                isActive.add(userDAO.isActive(userList.get(i).getEmail()));
            }
        }
        
        //get numberOfPage
        numberOfPages = tempUserList.size() / 10 + 1;
        
        return SUCCESS;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ArrayList<UserDetailsDTO> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<UserDetailsDTO> userList) {
        this.userList = userList;
    }

    public ArrayList<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(ArrayList<String> roleList) {
        this.roleList = roleList;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getTab() {
        return tab;
    }

    public ArrayList<Boolean> getIsActive() {
        return isActive;
    }

    public void setIsActive(ArrayList<Boolean> isActive) {
        this.isActive = isActive;
    }

    public String getActionName() {
        return actionName;
    }
    
}
