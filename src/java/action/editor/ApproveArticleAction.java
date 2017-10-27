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
    
    //Outputs
    private int numberOfPages;      //Number of pagination page
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ApproveArticleAction() {
    }
    
    public String execute() throws Exception {

        //approve article
        ArrayList<ArticleDTO> pendingList;
        ArticleDAO dao = new ArticleDAO();
        dao.approveArticle(articleID);
        pendingList = dao.getPendingList();
        
        //get numberOfPage
        numberOfPages = pendingList.size() / 10 + 1;

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
    
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
}
