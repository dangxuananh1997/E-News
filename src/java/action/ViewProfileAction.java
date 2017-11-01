/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import article.ArticleDAO;
import article.ArticleDTO;
import comment.CommentDAO;
import java.util.ArrayList;
import comment.CommentDTO;
import userdetails.UserDetailsDAO;
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
        String url = FAIL;

        UserDetailsDAO userDAO = new UserDetailsDAO();
        userDetails = userDAO.getUserDetails(userEmail);    //user details
        
        if (userDetails != null) {

            CommentDAO commentDAO = new CommentDAO();
            commentDAO.getCommentsOfProfile(userEmail);
            ArrayList<CommentDTO> comments = commentDAO.getCommentProfileList();

            this.articleTitleList = new ArrayList<>();
            this.commentList = new ArrayList<>();
                
            if (comments == null) {
                comments = new ArrayList<>();
            } else {
                for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < comments.size(); i++) {
                    this.commentList.add(comments.get(i));  //get 10 comments per page
                    CommentDTO commentDTO = comments.get(i);
                    int articleID = commentDTO.getArticleID();
                    
                    ArticleDAO articleDAO = new ArticleDAO();
                    ArticleDTO dto = articleDAO.getArticleDetails(articleID);
                    
                    this.articleTitleList.add(dto.getTitle());      //get 10 article title per page
                }
            }
            
            numberOfPages = comments.size() / 10 + 1;   //get number of pages
            
            url = SUCCESS;
        }
        return url;
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
