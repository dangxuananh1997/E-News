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
                    int articleID = rs.getInt("ArticleID");
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
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
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

    //update view count (ViewArticleAction)
    public boolean updateViewCount(int articleID, int viewCount)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update Article set ViewCount = ? where ArticleID = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, viewCount);
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
                String sql = "Select * from Article where AuthorEmail = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int articleID = rs.getInt("ArticleID");
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
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
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
                    int articleID = rs.getInt("ArticleID");
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
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
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
                    int articleID = rs.getInt("ArticleID");
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
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, statusID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
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

    /* Remove article*/
    public boolean deleteArticle(int articleID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE Article SET StatusID = ? WHERE ArticleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, 5);
                stm.setInt(2, articleID);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return true;
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
        return false;
    }

    private ArrayList<ArticleDTO> listArticle;


    //get all article list
    public ArrayList<ArticleDTO> viewAllArticle() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Article";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int articleID = rs.getInt("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int categoryID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");
                    if (this.listArticle == null) {
                        this.listArticle = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    listArticle.add(dto);
                }
            }
            return listArticle;
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

    //get name author
    public String getAuthorName(int articleID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String authorName = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT FullName FROM UserDetails u, Article a WHERE u.Email = a.AuthorEmail AND a.ArticleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                rs = stm.executeQuery();
                while(rs.next()) {
                    authorName = rs.getString(1);
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
        return authorName;
    }

    //get name of category
    public String getCategoryName(int categoryID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String categoryName = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT CategoryName FROM Category WHERE CategoryID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, categoryID);
                rs = stm.executeQuery();
                while(rs.next()) {
                    categoryName = rs.getString(1);
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
        return categoryName;
    }

    //get list name category
    public ArrayList<String> getCategoryNameList(ArrayList<Integer> categories) throws SQLException, NamingException {
        ArrayList<String> categoryNameList = new ArrayList<>();

        for (int i = 0; i < categories.size(); i++) {
            categoryNameList.add(getCategoryName(categories.get(i)));
        }

        return categoryNameList;
    }

    /* get all article by status (request delete) */

    private ArrayList<ArticleDTO> listArticleRequestedToDelete;

    public ArrayList<ArticleDTO> viewArticleRequestedToDelete() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Article WHERE StatusID = 4";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int articleID = rs.getInt("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int categoryID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");
                    if (this.listArticleRequestedToDelete == null) {
                        this.listArticleRequestedToDelete = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    listArticleRequestedToDelete.add(dto);
                }
            }
            return listArticleRequestedToDelete;
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

    /* Approve article */
    public boolean approveArticle(int articleID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE Article SET StatusID = ?, StatusDescription = ? WHERE ArticleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, 3);
                stm.setString(2, "Approved");
                stm.setInt(3, articleID);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return true;
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
        return false;
    }

    /* Reject article: where reject ?*/
    public boolean rejectArticle(int articleID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE Article SET StatusID = ?, StatusDescription = ? WHERE ArticleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, 1);
                stm.setString(2, "Reject");
                stm.setInt(3, articleID);
                int row = stm.executeUpdate();
                if(row > 0) {
                    return true;
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
        return false;
    }

    /* view pending article */
    private ArrayList<ArticleDTO> pendingList;

    public ArrayList<ArticleDTO> getPendingList() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Article WHERE StatusID = 2";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int articleID = rs.getInt("ArticleID");
                    String authorEmail = rs.getString("AuthorEmail");
                    String featureImage = rs.getString("FeatureImage");
                    int categoryID = rs.getInt("CategoryID");
                    String title = rs.getString("Title");
                    String articleContent = rs.getString("ArticleContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    int statusID = rs.getInt("StatusID");
                    String statusDescription = rs.getString("StatusDescription");
                    int viewCount = rs.getInt("ViewCount");
                    if (this.pendingList == null) {
                        this.pendingList = new ArrayList<>();
                    }
                    ArticleDTO dto = new ArticleDTO(articleID, authorEmail, featureImage, categoryID, title, articleContent, publishTime, statusID, statusDescription, viewCount);
                    pendingList.add(dto);
                }
            }
            return pendingList;
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
    
    public boolean addNewArticle(String authorEmail, String featureImage, int categoryID, String title, String articleContent, int statusID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO Article VALUES(?,?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, authorEmail);
                stm.setString(2, featureImage);
                stm.setInt(3, categoryID);
                stm.setString(4, title);
                stm.setString(5, articleContent);
                stm.setTimestamp(6, new Timestamp(new java.util.Date().getTime()));
                stm.setInt(7, statusID);
                stm.setString(8, null);
                stm.setInt(9, 0);
                return (stm.executeUpdate() > 0);
            }
            return false;
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
    
    
    public boolean updateArticle(int articleID, String featureImage, int categoryID, String title, String articleContent, int statusID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                if (!featureImage.isEmpty()) {
                    String sql = "UPDATE Article SET Title = ?, FeatureImage = ?, CategoryID = ?, ArticleContent = ?, PublishTime = ?, StatusID = ? WHERE ArticleID = ?";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, title);
                    stm.setString(2, featureImage);
                    stm.setInt(3, categoryID);
                    stm.setString(4, articleContent);
                    stm.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
                    stm.setInt(6, statusID);
                    stm.setInt(7, articleID);
                    return (stm.executeUpdate() > 0);
                } else {
                    String sql = "UPDATE Article SET Title = ?, CategoryID = ?, ArticleContent = ?, PublishTime = ?, StatusID = ? WHERE ArticleID = ?";
                    stm = con.prepareStatement(sql);
                    stm.setString(1, title);
                    stm.setInt(2, categoryID);
                    stm.setString(3, articleContent);
                    stm.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));
                    stm.setInt(5, statusID);
                    stm.setInt(6, articleID);
                    return (stm.executeUpdate() > 0);
                }
            }
            return false;
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
