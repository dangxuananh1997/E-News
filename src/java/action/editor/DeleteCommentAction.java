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
    private String actionName;
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public DeleteCommentAction() {
    }
    
    public String execute() throws Exception {
        
        CommentDAO dao = new CommentDAO();
        
        //Delete comment        
        dao.deleteComment(commentID);
        
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

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
    
}
