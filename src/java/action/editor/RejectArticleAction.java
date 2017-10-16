/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.editor;

/**
 *
 * @author dangxuananh1997
 */
public class RejectArticleAction {
    
    //Inputs
    private int articleID;
    private String reason;
    
    //Outputs
    private int numberOfPages;      //Number of pagination page
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public RejectArticleAction() {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
}
