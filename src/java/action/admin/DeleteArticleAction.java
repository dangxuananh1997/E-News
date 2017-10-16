/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

/**
 *
 * @author dangxuananh1997
 */
public class DeleteArticleAction {
    
    //Inputs
    private int articleID;
    private int pageNumber;             //Current Page Number
    private String viewActionName;      //All Article or Delete Request
    
    //Outputs
    private int numberOfPages;      //Number of pagination page
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public DeleteArticleAction() {
    }
    
    public String execute() throws Exception {
        
        
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

    public String getViewActionName() {
        return viewActionName;
    }

    public void setViewActionName(String viewActionName) {
        this.viewActionName = viewActionName;
    }
    
}
