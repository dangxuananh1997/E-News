/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;
import java.sql.SQLException;
import javax.naming.NamingException;

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

    public ViewByAuthorAction() {
    }

    public String execute() throws NamingException, SQLException {
        String url = FAIL;

        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.getArticlesByAuthor(authorEmail);
        ArrayList<ArticleDTO> articles = articleDAO.getArticleListByAuthor(); //list of articles by author

        if (articles != null) {
            if (this.articleList == null) {
                this.articleList = new ArrayList<>();
            }
            numberOfPages = articles.size() / 10;    //get number of pages
            for (int i = numberOfPages * 10 - 10; i < numberOfPages * 10; i++) {
                this.articleList.add(articles.get(i));  //10 articles per page
                if (i == articles.size()) {
                    break;
                }
            }
            url = SUCCESS;
        }
        return url;
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
