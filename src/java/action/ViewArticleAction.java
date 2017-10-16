/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.ArrayList;
import article.ArticleDTO;
import comment.CommentDTO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewArticleAction {
    
    //Inputs
    private String articleID;
    
    //Outputs
    private ArticleDTO article;                         //Article
    private UserDetailsDTO author;                      //Author
    private ArrayList<CommentDTO> commentList;          //List of comments
    private ArrayList<UserDetailsDTO> commenterList;    //List of commenters
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewArticleAction() throws Exception {
    }
    
    public String execute() {
        
        
        return SUCCESS;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public ArticleDTO getArticle() {
        return article;
    }

    public void setArticle(ArticleDTO article) {
        this.article = article;
    }

    public UserDetailsDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDetailsDTO author) {
        this.author = author;
    }

    public ArrayList<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<UserDetailsDTO> getCommenterList() {
        return commenterList;
    }

    public void setCommenterList(ArrayList<UserDetailsDTO> commenterList) {
        this.commenterList = commenterList;
    }
    
}
