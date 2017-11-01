/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;

/**
 *
 * @author dangxuananh1997
 */
public class CancelDeleteRequestAction {
    
    //Inputs
    private int articleID;
    private int pageNumber;         //Current Page Number
    
    //Outputs
    private int tab = 1;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public CancelDeleteRequestAction() {
    }
    
    public String execute() throws Exception {
        
        String url = FAIL;
        
        ArticleDAO dao = new ArticleDAO();
        boolean result = dao.cancelRequestDelete(articleID);
        if(result)
            url = SUCCESS;
        return url;
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

    public int getTab() {
        return tab;
    }

    public void setTab(int tab) {
        this.tab = tab;
    }
    
}
