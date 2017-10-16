/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.ArrayList;
import comment.CommentDTO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewProfileAction {
    
    //Inputs
    private String userEmail;
    private int pageNumber = 1;  //Display 10 comments in this page | Default: 1
    
    //Outputs
    private int numberOfPages;
    private UserDetailsDTO userDetails;
    private ArrayList<CommentDTO> commentList;
    private ArrayList<String> articleTitleList;
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    
    public ViewProfileAction() {
    }
    
    public String execute() throws Exception {
        
        
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }

    public ArrayList<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<String> getArticleTitleList() {
        return articleTitleList;
    }

    public void setArticleTitleList(ArrayList<String> articleTitleList) {
        this.articleTitleList = articleTitleList;
    }
    
}
