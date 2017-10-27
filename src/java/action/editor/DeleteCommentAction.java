/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.editor;

import comment.CommentDAO;
import comment.CommentDTO;
import java.util.ArrayList;

/**
 *
 * @author dangxuananh1997
 */
public class DeleteCommentAction {
    
    //Inputs
    private int commentID;
    private int pageNumber;         //Current Page Number
    
    //Outputs
    private int numberOfPages;      //Number of pagination page
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public DeleteCommentAction() {
    }
    
    public String execute() throws Exception {
        
        CommentDAO dao = new CommentDAO();
        ArrayList<CommentDTO> listCommentActive;
        
        //Delete comment        
        dao.deleteComment(commentID);
        listCommentActive = dao.getArticleCommentList();
        
        //numberOfPage
        numberOfPages = listCommentActive.size() / 10 + 1;
        
        return SUCCESS;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
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
    
}
