/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;
import comment.CommentDAO;
import comment.CommentDTO;
import java.sql.SQLException;
import javax.naming.NamingException;
import userdetails.UserDetailsDAO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewArticleAction {

    //Inputs
    private int articleID;
    private boolean commentOff = false;

    //Outputs
    private ArticleDTO article;                         //Article
    private UserDetailsDTO author;                      //Author
    private ArrayList<CommentDTO> commentList;          //List of comments
    private ArrayList<UserDetailsDTO> commenterList;    //List of commenters

    //Return
    private final String SUCCESS = "success";

    public ViewArticleAction() throws Exception {
    }

    public String execute() throws NamingException, SQLException {
        
        ArticleDAO articleDAO = new ArticleDAO();
        article = articleDAO.getArticleDetails(articleID);  //get article details

        if (article != null) {  //article details not null

            if (!commentOff)
                articleDAO.updateViewCount(articleID, article.getViewCount() + 1);  //update view count

            UserDetailsDAO userDAO = new UserDetailsDAO();
            author = userDAO.getUserDetails(article.getAuthorEmail());  //get author email

            CommentDAO commentDAO = new CommentDAO();
            commentDAO.getCommentsOfArticle(articleID);
            commentList = commentDAO.getArticleCommentList();   //get comments

            if (commentList != null) {  //comment list not null
                this.commenterList = new ArrayList<>();
                for (CommentDTO commentDTO : commentList) {
                    String commenterEmail = commentDTO.getUserEmail();
                    UserDetailsDTO userDTO = userDAO.getUserDetails(commenterEmail);
                    this.commenterList.add(userDTO);    //get list of commenter details
                }
            }
        }
        
        return SUCCESS;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
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

    public boolean isCommentOff() {
        return commentOff;
    }

    public void setCommentOff(boolean commentOff) {
        this.commentOff = commentOff;
    }

}
