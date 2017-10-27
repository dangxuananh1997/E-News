/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.NamingException;

import article.ArticleDTO;
import userdetails.UserDetailsDTO;
import utils.DBUtils;

/**
 *
 * @author dangxuananh1997
 */
public class CommentDAO implements Serializable {

    private ArrayList<CommentDTO> commentProfileList;  //list of user comments (ViewProfileAction)
    
    public ArrayList<CommentDTO> getCommentProfileList(){
        return commentProfileList;
    }
    //get user comments to display in profile page (ViewProfileAction)
    public void getCommentsOfProfile(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Comment where UserEmail = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String userEmail = rs.getString("UserEmail");
                    int articleID = rs.getInt("ArticleID");
                    String commentContent = rs.getString("CommentContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    boolean isActive = rs.getBoolean("IsActive");

                    CommentDTO dto = new CommentDTO(userEmail, articleID, commentContent, publishTime, isActive);
                    if (this.commentProfileList == null) {
                        this.commentProfileList = new ArrayList<>();
                    }
                    this.commentProfileList.add(dto);
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

    //insert user comment into database (CommentAction)
    public boolean insertComment(String email, int articleID, String commentContent)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Insert into Comment(UserEmail, ArticleID, CommentContent, PublishTime, IsActive) "
                        + "values(?,?,?,CURRENT_TIMESTAMP,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setInt(2, articleID);
                stm.setString(3, commentContent);
                stm.setBoolean(4, true);
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

    private ArrayList<CommentDTO> articleCommentList;  //list of CommentDTO (ViewArticleAction)

    public ArrayList<CommentDTO> getArticleCommentList() {   //return list of CommentDTO (ViewArticleAction)
        return articleCommentList;
    }
    //get list of CommentDTO (ViewArticleAction)

    public void getCommentsOfArticle(int articleID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        CommentDTO dto;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from Comment where ArticleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    String userEmail = rs.getString("UserEmail");
                    int ID = rs.getInt("ArticleID");
                    String commentContent = rs.getString("CommentContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    boolean isActive = rs.getBoolean("IsActive");

                    if (isActive) {
                        dto = new CommentDTO(userEmail, ID, commentContent, publishTime, isActive);
                        if (this.articleCommentList == null) {
                            this.articleCommentList = new ArrayList<>();
                        }
                        this.articleCommentList.add(dto);
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

    /* Delete comment by editor */
    public boolean deleteComment(int commentID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "UPDATE Comment SET IsActive = ? WHERE CommentID = ?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, false);
                stm.setInt(2, commentID);
                int row = stm.executeUpdate();
                if (row > 0) {
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

    /* get all article by id */
    private ArrayList<String> articleIDList;

    public ArrayList<String> getAllArticleID() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT ArticleID FROM Article";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ArtcileID");
                    if (this.articleIDList == null) {
                        this.articleIDList = new ArrayList<>();
                    }
                    articleIDList.add(id);
                }
            }
            return articleIDList;
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

    /* get all article by title */

    public String getArticleTitle(int articleID) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String title = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT Title FROM Article WHERE ArticleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, articleID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    title = rs.getString("Title");                                        
                }
            }
            return title;
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
    
    /* get all comment isActive */
    
    public ArrayList<CommentDTO> getCommentActive() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<CommentDTO> commentActiveList = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT * FROM Comment WHERE IsActive = ? ORDER BY PublishTime DESC";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, true);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int commentID = rs.getInt("CommentID");
                    String authorEmail = rs.getString("UserEmail");
                    int articleID = rs.getInt("ArticleID");
                    String commentContent = rs.getString("CommentContent");
                    Timestamp publishTime = rs.getTimestamp("PublishTime");
                    boolean isActive = rs.getBoolean("IsActive");                    
                    CommentDTO dto = new CommentDTO(authorEmail, articleID, commentContent, publishTime, isActive);
                    commentActiveList.add(dto);
                }
            }
            return commentActiveList;
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
