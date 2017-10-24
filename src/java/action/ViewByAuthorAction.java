/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.ArrayList;
import article.ArticleDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewByAuthorAction {
    
    //inputs
    private String authorEmail;
    private int pageNumber = 1;  //Display 10 article in this page | Default: 1
    
    //Outputs
    private int numberOfPages;                  //Number of pagination page
    private ArrayList<ArticleDTO> articleList;  //List of articles to show on view
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewByAuthorAction() throws Exception {
    }
    
    public String execute() {
        
        return SUCCESS;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
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

    public ArrayList<ArticleDTO> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<ArticleDTO> articleList) {
        this.articleList = articleList;
    }
}
