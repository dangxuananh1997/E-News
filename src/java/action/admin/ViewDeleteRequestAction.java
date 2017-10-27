/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;
import userdetails.UserDetailsDAO;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewDeleteRequestAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<ArticleDTO> articleList;
    private ArrayList<UserDetailsDTO> authorList;
    private ArrayList<String> categoryList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 3;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewDeleteRequestAction() {
    }
    
    public String execute() throws Exception {
        
        //list article
        ArticleDAO dao = new ArticleDAO();
        UserDetailsDAO udDao = new UserDetailsDAO();
        articleList = new ArrayList<>();
        authorList = new ArrayList<>();
        categoryList = new ArrayList<>();
        ArrayList<ArticleDTO> tempArticleList = dao.viewArticleRequestedToDelete();        
        
        //get numberOfPage
        numberOfPages = tempArticleList.size() / 10 + 1;
        
        for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < tempArticleList.size(); i++) {
            this.articleList.add(tempArticleList.get(i));
        }
        
        //list authors & categories

        for (int i = 0; i < 10; i++) {
            this.authorList.add(udDao.getUserDetails(articleList.get(i).getAuthorEmail()));
            this.categoryList.add(dao.getCategoryName(articleList.get(i).getCategoryID()));
            System.out.println(articleList.get(i));
            System.out.println(authorList.get(i));
            System.out.println(categoryList.get(i));
        }
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
