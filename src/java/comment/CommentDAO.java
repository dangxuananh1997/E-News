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
import utils.DBUtils;

/**
 *
 * @author dangxuananh1997
 */
public class CommentDAO implements Serializable {
    
    private ArrayList<CommentDTO> commentProfileList;  //list of user comments (ViewProfileAction)
    
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
                    if(this.commentProfileList == null){
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
                String sql = "Insert into Comment(UserEmail, ArticleID, CommentContent, PublishTime, IsActive) values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setInt(2, articleID);
                stm.setString(3, commentContent);
                stm.setString(4, "current_timestamp");
                stm.setBoolean(5, true);
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
    
   //get list of CommentDTO (ViewArticleAction)
    public void getCommentsOfArticle(int articleID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

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
                    
                    CommentDTO dto = new CommentDTO(userEmail, ID, commentContent, publishTime, isActive);
                    if(this.articleCommentList == null){
                        this.articleCommentList = new ArrayList<>();
                    }
                    this.articleCommentList.add(dto);
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
