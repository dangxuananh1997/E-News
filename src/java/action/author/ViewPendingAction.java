/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewPendingAction {

    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1

    //Outputs
    private ArrayList<ArticleDTO> pendingList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 2;            //Tab number

    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public ViewPendingAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;

        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.getArticlesByStatus(2);
        ArrayList<ArticleDTO> articles = articleDAO.getArticleListByStatus(); //list of all pending articles

        if (articles != null) {
            for (ArticleDTO article : articles) {
                System.out.println(article);
            }
            this.pendingList = new ArrayList<>();
            numberOfPages = articles.size() / 10 + 1;    //get number of pages
            for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < articles.size(); i++) {
                this.pendingList.add(articles.get(i));  //get 10 article per page
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

    public ArrayList<ArticleDTO> getPendingList() {
        return pendingList;
    }

    public void setPendingList(ArrayList<ArticleDTO> pendingList) {
        this.pendingList = pendingList;
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
