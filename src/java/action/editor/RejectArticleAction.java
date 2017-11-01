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
public class RejectArticleAction {

    //Inputs
    private int articleID;
    private String reason;
    private String actionName;

    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public RejectArticleAction() {
    }

    public String execute() throws Exception {

        ArticleDAO dao = new ArticleDAO();

        //reject article
        dao.rejectArticle(articleID, reason);

        return SUCCESS;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

}
