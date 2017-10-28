/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import article.ArticleDTO;
import com.opensymphony.xwork2.ActionContext;
import java.util.ArrayList;
import java.util.Map;
import userdetails.UserDetailsDTO;

/**
 *
 * @author Administrator
 */
public class ViewRejectedAction {

    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1
    private String email;
    
    //Outputs
    private ArrayList<ArticleDTO> pendingList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 2;            //Tab number

    //Return
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    public ViewRejectedAction() {
    }

    public String execute() throws Exception {
        String url = FAIL;
        
        Map session = ActionContext.getContext().getSession();
        UserDetailsDTO dto = (UserDetailsDTO) session.get("USERDETAILS");
        email = dto.getEmail(); //get email from session
        
        ArticleDAO articleDAO = new ArticleDAO();
        articleDAO.getArticlesByStatusAndAuthor(6, email);
        ArrayList<ArticleDTO> articles = articleDAO.getArticleListByStatusAndAuthor(); //list of all rejected articles

        if (articles != null) {
            for (ArticleDTO article : articles) {
                System.out.println("ViewRejectedAction " + article.getTitle());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}
