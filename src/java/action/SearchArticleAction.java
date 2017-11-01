/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;
import userdetails.UserDetailsDAO;

/**
 *
 * @author dangxuananh1997
 */
public class SearchArticleAction {

    //Inputs
    private String searchValue;
    private int pageNumber = 1;  //Display 10 article in this page | Default: 1

    //Outputs
    private int numberOfPages;                  //Number of pagination page
    private ArrayList<ArticleDTO> articleList;  //List of articles to show on view
    private ArrayList<String> authorNameList;   //List of authors

    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public SearchArticleAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        
        this.articleList = new ArrayList<>();
        this.authorNameList = new ArrayList<>();
        ArticleDAO articleDAO = new ArticleDAO();
        
        articleDAO.searchByValue(searchValue);
        
        ArrayList<ArticleDTO> articles = articleDAO.getsearchArticleList(); //list of articles by searching
        
        if (articles == null) {
            articles = new ArrayList<>();
        } else {
            UserDetailsDAO userDAO = new UserDetailsDAO();
            ArrayList<String> names = new ArrayList<>();

            for (ArticleDTO articleDTO : articles) {
                System.out.println(articleDTO);
                String authorName = userDAO.getFullName(articleDTO.getAuthorEmail());
                names.add(authorName);    //get list of author names
            }
            
            for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < articles.size(); i++) {
                this.articleList.add(articles.get(i));  //get 10 article for each page
                this.authorNameList.add(names.get(i));  //get 10 author name for each page      
            }
        }
        
        numberOfPages = articles.size() / 10 + 1;    //get number of pages
            
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
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

    public ArrayList<String> getAuthorNameList() {
        return authorNameList;
    }

    public void setAuthorNameList(ArrayList<String> authorNameList) {
        this.authorNameList = authorNameList;
    }

}
