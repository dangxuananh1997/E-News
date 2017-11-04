/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import java.util.ArrayList;
import article.ArticleDTO;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class ViewApprovedAction {
    
    //Inputs
    private int pageNumber = 1;     //Display 20 articles in this page | Default: 1
    private String email;
    //Outputs
    private ArrayList<ArticleDTO> approvedList;
    private int numberOfPages;      //Number of pagination page
    private final int tab = 3;            //Tab number
    
    //Return
    private final String SUCCESS = "success";
    
    public ViewApprovedAction() {
    }
    
    public String execute() throws Exception {
        
        Map session = ActionContext.getContext().getSession();
        UserDetailsDTO dto = (UserDetailsDTO) session.get("USERDETAILS");
        email = dto.getEmail(); //get email from session
        System.out.println(email);
        approvedList = new ArrayList<>();
            
        ArticleDAO articleDAO = new ArticleDAO();
        ArrayList<ArticleDTO> articles = articleDAO.getApprovedArticlesByAuthor(email);

        if (articles == null)
            articles = new ArrayList<>();
        else {
            for (int i = pageNumber * 10 - 10; i < pageNumber * 10 && i < articles.size(); i++) {
                this.approvedList.add(articles.get(i));
            }
        }
        
        numberOfPages = articles.size() / 10 + 1;    //get number of pages
            
        return SUCCESS;
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
