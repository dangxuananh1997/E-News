/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.editor;

import article.ArticleDAO;
import article.ArticleDTO;
import java.util.ArrayList;

/**
 *
 * @author dangxuananh1997
 */
public class ApproveArticleAction {
    
    //Inputs
    private int articleID;
    private int pageNumber;         //Current Page Number
    private String actionName;
    
    //Return
    private final String SUCCESS = "success";
    
    public ApproveArticleAction() {
    }
    
    public String execute() throws Exception {

        //approve article
        ArticleDAO dao = new ArticleDAO();
        dao.approveArticle(articleID);

        return SUCCESS;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
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
