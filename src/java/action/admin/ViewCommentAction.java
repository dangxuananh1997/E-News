/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import java.util.ArrayList;

import comment.CommentDAO;
import comment.CommentDTO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewCommentAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 10 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<CommentDTO> commentList; 
    private ArrayList<UserDetailsDTO> commenterList; 
    private ArrayList<String> articleTitle;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 4;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewCommentAction() {
    }
    
    public String execute() throws Exception {

        CommentDAO dao = new CommentDAO();
        ArrayList<CommentDTO> tempCommentList = dao.getCommentActive();
        commentList = new ArrayList<>();

        //get numberOfPage
        numberOfPages = tempCommentList.size() / 10 + 1;

        //get commentList
        for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < tempCommentList.size(); i++) {
            this.commentList.add(tempCommentList.get(i));
        }

        //get artivcleTitle & commenterList
        for (int i = 0; i < 10; i++) {
//            this.commentList.add(dao.getCommentContent(articleTitle.get(i)));
//            this.commenterList.add(dao.getCommenter(commentList.get(i)));
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

    public ArrayList<CommentDTO> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<UserDetailsDTO> getCommenterList() {
        return commenterList;
    }

    public void setCommenterList(ArrayList<UserDetailsDTO> commenterList) {
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
