/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import article.ArticleDAO;
import article.ArticleDTO;
import userdetails.UserDetailsDTO;

import javax.naming.NamingException;

/**
 *
 * @author dangxuananh1997
 */
public class ViewAllArticleAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<ArticleDTO> articleList;
    private ArrayList<UserDetailsDTO> authorList;
    private ArrayList<String> categoryList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 1;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewAllArticleAction() {
    }
    
    public String execute() throws Exception {

        articleList = new ArrayList<>();
        ArticleDAO dao = new ArticleDAO();
        ArrayList<ArticleDTO> allArticleList = dao.viewAllArticle();
        for(int i = (pageNumber - 1 ) * 10; i <= allArticleList.size(); i++) {
            articleList.add(allArticleList.get(i));
        }

        //authorList

        return SUCCESS;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ArrayList<ArticleDTO> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<ArticleDTO> articleList) {
        this.articleList = articleList;
    }

    public ArrayList<UserDetailsDTO> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ArrayList<UserDetailsDTO> authorList) {
        this.authorList = authorList;
    }

    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(ArrayList<String> categoryList) {
        this.categoryList = categoryList;
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
