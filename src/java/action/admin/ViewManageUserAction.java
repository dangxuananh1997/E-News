/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import article.ArticleDAO;
import article.ArticleDTO;
import java.util.ArrayList;
import role.RoleDAO;
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
    private int numberOfPages;      //Number of pagination page
    private final int tab = 5;      //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewManageUserAction() {
    }
    
    public String execute() throws Exception {
        
        //list user
        UserDetailsDAO dao = new UserDetailsDAO();
        RoleDAO rDao = new RoleDAO();
        userList = new ArrayList<>();
        roleList = new ArrayList<>();
        ArrayList<UserDetailsDTO> tempArticleList = dao.viewAllUsers();        
        
        //get numberOfPage
        numberOfPages = tempArticleList.size() / 10 + 1;
        
        for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < tempArticleList.size(); i++) {
            this.userList.add(tempArticleList.get(i));
        }
        
        //list role

        for (int i = 0; i < 10; i++) {
            roleList.add(rDao.getRoleName(userList.get(i).getEmail()));
            System.out.println(userList.get(i));
            System.out.println(roleList.get(i));
        }
        
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
    
}
