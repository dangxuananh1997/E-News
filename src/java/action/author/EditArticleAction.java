/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.author;

import article.ArticleDAO;
import article.ArticleDTO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 *
 * @author dangxuananh1997
 */
public class EditArticleAction {
    
    //Inputs
    private int articleID;   //optional
    private String authorEmail; //get from session
    private File featureImage;
    private String featureImageContentType;
    private String featureImageFileName;
    private int categoryID;
    private String title;
    private String articleContent;
    private ArticleDTO article;
    
    //Outputs
    
    //Return
    private final String SUCCESS = "success";
    
    public EditArticleAction() {
    }
    
    public String execute() throws Exception {
        
        //get image string
        BASE64Encoder encoder = new BASE64Encoder(); 
        BufferedImage bi;
        bi = ImageIO.read(featureImage); 
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
        ImageIO.write(bi, "jpg", baos); 
        byte[] bytes = baos.toByteArray(); 
        String img = encoder.encodeBuffer(bytes).trim(); 
        
        
        ArticleDAO dao = new ArticleDAO();
        article = dao.getArticleDetails(articleID);
        
        dao.updateDraft(authorEmail, img, categoryID, title, articleContent);
        return SUCCESS;
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

    public ArticleDTO getArticle() {
        return article;
    }

    public void setArticle(ArticleDTO article) {
        this.article = article;
    }
    
}
