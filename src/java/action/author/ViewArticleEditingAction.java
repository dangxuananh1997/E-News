/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import article.ArticleDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewArticleEditingAction {
    
    //Inputs
    private int articleID;   //optional
    
    //Outputs
    private ArticleDTO article;
    
    //Return
    private final String SUCCESS = "success";    
    private final String FAIL = "fail";
    
    public ViewArticleEditingAction() {
    }
    
    public String execute() throws Exception {
        ArticleDAO dao = new ArticleDAO();
        
        article = dao.getArticleDetails(articleID);
        
        if (article == null) return FAIL;
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
    
}
