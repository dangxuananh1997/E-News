/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author dangxuananh1997
 */
public class CommentDTO implements Serializable {
    
    private String userEmail;
    private int articleID;
    private String commentContent;
    private Timestamp publishTime;
    private boolean isActive;

    public CommentDTO(String userEmail, int articleID, String commentContent, Timestamp publishTime, boolean isActive) {
        this.userEmail = userEmail;
        this.articleID = articleID;
        this.commentContent = commentContent;
        this.publishTime = publishTime;
        this.isActive = isActive;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "CommentDTO{" + "userEmail=" + userEmail + ", articleID=" + articleID + ", commentContent=" + commentContent + ", publishTime=" + publishTime + ", isActive=" + isActive + '}';
    }
    
}
