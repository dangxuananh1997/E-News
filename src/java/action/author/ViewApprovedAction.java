/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;
import userdetails.UserDetailsDAO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewApprovedAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1
    
    //Outputs
    private ArrayList<ArticleDTO> approvedList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 3;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public ViewApprovedAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;

        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.getArticlesByStatus(3);
        ArrayList<ArticleDTO> articles = articleDAO.getArticleListByStatus(); //list of all approved articles

        if (articles != null) {
            numberOfPages = articles.size() / 10 + 1;    //get number of pages
            this.approvedList = new ArrayList<>();
            for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < articles.size(); i++) {
                this.approvedList.add(articles.get(i));
            }
            url = SUCCESS;
        }
        return url;        
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public ArrayList<ArticleDTO> getApprovedList() {
        return approvedList;
    }

    public void setApprovedList(ArrayList<ArticleDTO> approvedList) {
        this.approvedList = approvedList;
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
