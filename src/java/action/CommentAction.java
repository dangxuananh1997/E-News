/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import comment.CommentDAO;

/**
 *
 * @author dangxuananh1997
 */
public class CommentAction {
    
    //Inputs
    private String commenterEmail;      //get from session
    private String commentContent;
    private int articleID;
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public CommentAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        
        CommentDAO dao = new CommentDAO();
        boolean result = dao.insertComment(commenterEmail, articleID, commentContent);
        if(result){
            url = SUCCESS;
        }
        return url;
    }

    public String getCommenterEmail() {
        return commenterEmail;
    }

    public void setCommenterEmail(String commenterEmail) {
        this.commenterEmail = commenterEmail;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }
    
}
