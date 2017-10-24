/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package article;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author dangxuananh1997
 */
public class ArticleDTO implements Serializable {
    
    private int articleID;
    private String authorEmail;
    private String featureImage;
    private int categoryID;
    private String title;
    private String articleContent;
    private Timestamp publishTime;
    private int statusID;
    private String statusDescription;
    private int viewCount;

    public ArticleDTO(int articleID, String authorEmail, String featureImage, int categoryID, String title, String articleContent, Timestamp publishTime, int statusID, String statusDescription, int viewCount) {
        this.articleID = articleID;
        this.authorEmail = authorEmail;
        this.featureImage = featureImage;
        this.categoryID = categoryID;
        this.title = title;
        this.articleContent = articleContent;
        this.publishTime = publishTime;
        this.statusID = statusID;
        this.statusDescription = statusDescription;
        this.viewCount = viewCount;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(String featureImage) {
        this.featureImage = featureImage;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" + "articleID=" + articleID + ", authorEmail=" + authorEmail + ", featureImage=" + featureImage + ", categoryID=" + categoryID + ", title=" + title + ", articleContent=" + articleContent + ", publishTime=" + publishTime + ", statusID=" + statusID + ", statusDescription=" + statusDescription + ", viewCount=" + viewCount + '}';
    }
    
}
