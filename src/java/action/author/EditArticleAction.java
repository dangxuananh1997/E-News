/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import article.ArticleDTO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;
import userdetails.UserDetailsDTO;

/**
 *
 * @author dangxuananh1997
 */
public class EditArticleAction extends ActionSupport  {
    
    //Inputs
    private int articleID;   //optional
    private String authorEmail; //get from session
    private File featureImage;
    private String featureImageContentType;
    private String featureImageFileName;
    private int categoryID;
    private String title;
    private String articleContent;
    private String btnAction;
    
    //Return
    private final String SUCCESSDRAFT = "successDraft";
    private final String SUCCESSPENDING = "successPending";
    private final String FAIL = "fail";
    
    public EditArticleAction() {
    }
    
    public String execute() throws Exception {
        String url = FAIL;
        
        ArticleDAO dao = new ArticleDAO();
        
        String img = "";
        //get image string
        if (featureImage != null) {
            BASE64Encoder encoder = new BASE64Encoder();
            BufferedImage bi;
            bi = ImageIO.read(featureImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            img = encoder.encodeBuffer(bytes).trim();
        }
        
        UserDetailsDTO author = (UserDetailsDTO) ActionContext.getContext().getSession().get("USERDETAILS");
        authorEmail = author.getEmail();
        
        int statusID = btnAction.equals("draft") ? 1 : 2;
        
        if (articleID != 0) {
            if (!dao.updateArticle(articleID, img, categoryID, title, articleContent, statusID))
                return FAIL;

        } else {
            if (!dao.addNewArticle(authorEmail, img, categoryID, title, articleContent, statusID))
                return FAIL;
        }
        
        return SUCCESSPENDING;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public File getFeatureImage() {
        return featureImage;
    }

    public void setFeatureImage(File featureImage) {
        this.featureImage = featureImage;
    }

    public String getFeatureImageContentType() {
        return featureImageContentType;
    }

    public void setFeatureImageContentType(String featureImageContentType) {
        this.featureImageContentType = featureImageContentType;
    }

    public String getFeatureImageFileName() {
        return featureImageFileName;
    }

    public void setFeatureImageFileName(String featureImageFileName) {
        this.featureImageFileName = featureImageFileName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getBtnAction() {
        return btnAction;
    }

    public void setBtnAction(String btnAction) {
        this.btnAction = btnAction;
    }
}
