/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package article;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author dangxuananh1997
 */
public class ArticleDAO implements Serializable {

    private ArrayList<String> articleTitleList; //list of all articles related to comments (ViewProfileAction)

    //get all articles related to comments (ViewProfileAction)
    public void getCommentRelatedArticles(int[] articleID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                for (int ID : articleID) {
                    String sql = "Select * from Article where ArticleID = ? ";
                    stm = con.prepareStatement(sql);
                    stm.setInt(1, ID);
                    rs = stm.executeQuery();

                    if (rs.next()) {
                        String title = rs.getString("Title");
                        if (this.articleTitleList == null) {
                            this.articleTitleList = new ArrayList<>();
                        }
                        this.articleTitleList.add(title);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private ArrayList<ArticleDTO> searchArticleList; // list of all search articles (SearchArticleAction)
    
    public ArrayList<ArticleDTO> getsearchArticleList(){  //return list of all search articles (SearchArticleAction)
        return searchArticleList;
    }
    //search article by search value (SearchArticleAction)
    public void searchByValue(String searchValue)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Article where Title like ? or ArticleContent like ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");
                rs = stm.executeQuery();

                while (rs.next()) {
                    String articleID = rs.getString("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int categoryID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");

                    if (this.searchArticleList == null) {
                        this.searchArticleList = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(statusID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    this.searchArticleList.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    //get article details (EditArticleAction / ViewArticleAction)
    public ArticleDTO getArticleDetails(int articleID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Article where ArticleID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                rs = stm.executeQuery();

                if (rs.next()) {
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int categoryID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");

                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    private ArrayList<ArticleDTO> articleListByAuthor; //list of articles by author (ViewByAuthorAction)
    
    public ArrayList<ArticleDTO> getArticleListByAuthor(){  //return list of articles by author (ViewByAuthorAction)
        return articleListByAuthor;
    }
    //get articles by author (ViewByAuthorAction)
    public void getArticlesByAuthor(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Article where Email = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String articleID = rs.getString("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int categoryID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");

                    if (this.articleListByAuthor == null) {
                        this.articleListByAuthor = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(statusID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    this.articleListByAuthor.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private ArrayList<ArticleDTO> articleListByCategory; // list of all articles by category (ViewByCategoryAction)
    
    public ArrayList<ArticleDTO> getArticleListByCategory(){
        return articleListByCategory;
    }
    //search article by category (ViewByCategoryAction)
    public void searchByCategory(int categoryID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Article where CategoryID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String articleID = rs.getString("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int ID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");

                    if (this.articleListByCategory == null) {
                        this.articleListByCategory = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(statusID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    this.articleListByCategory.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    //update draft (EditArticalAction)
    public boolean updateDraft(String authorEmail, String featureImage, int categoryID,
            String title, String articleContent)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update Article set FeatureImage = ?, "
                        + "CategoryID = ?, Title = ?, ArticleContent = ? where AuthorEmail = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, featureImage);
                stm.setInt(2, categoryID);
                stm.setString(3, title);
                stm.setString(4, articleContent);
                stm.setString(5, authorEmail);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    //update article status to request delete (RequestDeleteAction)
    public boolean updateRequestDelete(int articleID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update Article set StatusID = ? where ArticleID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, 4);
                stm.setInt(2, articleID);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }

        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    private ArrayList<ArticleDTO> articleListByStatus; //list of  articles by status (ViewApprovedAction/ ViewDraftAction/ 
                                                                                        //ViewPendingAction / ViewHomeAction)
    
    public ArrayList<ArticleDTO> getArticleListByStatus(){ //return list of articles by status(ViewApprovedAction/ ViewDraftAction/ 
                                                                                        //ViewPendingAction / ViewHomeAction)
        return articleListByStatus;
    }
    //get all articles by status (ViewApprovedAction/ ViewDraftAction/ ViewPendingAction/ ViewHomeAction)
    public void getArticlesByStatus(int statusID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Article where StatusID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, statusID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String articleID = rs.getString("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int ID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int status = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");

                    if (this.articleListByStatus == null) {
                        this.articleListByStatus = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(statusID, authorEmail, featureImage, statusID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    this.articleListByStatus.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
