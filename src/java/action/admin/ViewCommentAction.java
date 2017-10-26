/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import java.util.ArrayList;

import comment.CommentDAO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewCommentAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 10 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<String> articleTitle;
    private ArrayList<String> commentList;
    private ArrayList<String> commenterList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 4;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewCommentAction() {
    }
    
    public String execute() throws Exception {

        CommentDAO dao = new CommentDAO();
        ArrayList<String> tempArticleTitle = dao.getArticleTitle();
        articleTitle = new ArrayList<>();

        //get numberOfPage
        numberOfPages = tempArticleTitle.size() / 10 + 1;

        //get articleTitle
        for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < tempArticleTitle.size(); i++) {
            this.articleTitle.add(tempArticleTitle.get(i));
        }

        //get commentList & commenterList
        for (int i = 0; i < 10; i++) {
            this.commentList.add(dao.getCommentContent(articleTitle.get(i)));
            this.commenterList.add(dao.getCommenter(commentList.get(i)));
        }

        return SUCCESS;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ArrayList<String> getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(ArrayList<String> articleTitle) {
        this.articleTitle = articleTitle;
    }

    public ArrayList<String> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<String> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<String> getCommenterList() {
        return commenterList;
    }

    public void setCommenterList(ArrayList<String> commenterList) {
        this.commenterList = commenterList;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getTab() {
        return tab;
    }
    
}
