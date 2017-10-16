/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.editor;

import java.util.ArrayList;
import article.ArticleDTO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewPendingAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<ArticleDTO> pendingList;
    private ArrayList<UserDetailsDTO> authorList;
    private ArrayList<String> categoryList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 1;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewPendingAction() {
    }
    
    public String execute() throws Exception {
        
        
        return SUCCESS;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ArrayList<ArticleDTO> getPendingList() {
        return pendingList;
    }

    public void setPendingList(ArrayList<ArticleDTO> pendingList) {
        this.pendingList = pendingList;
    }

    public ArrayList<UserDetailsDTO> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ArrayList<UserDetailsDTO> authorList) {
        this.authorList = authorList;
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
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
