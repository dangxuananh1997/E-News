/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdetails;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
//import java.util.StringTokenizer;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
public class UserDetailsDAO implements Serializable {

    //get user details (ViewProfileAction / UpdateProfileAction/ ViewArticleAction)
    public UserDetailsDTO getUserDetails(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from UserDetails where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    String name = rs.getString("FullName");
                    int genderID = rs.getInt("GenderID");
                    Date birthDate = rs.getDate("BirthDate");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    String profilePicture = rs.getString("ProfilePicture");
                    
                    UserDetailsDTO user = new UserDetailsDTO(email, name, genderID, birthDate, phone, address, profilePicture);
                    return user;
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

    //insert email and fullname into database (RegisterAction)
    public boolean insertEmailAndFullName(String email, String name)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Insert into UserDetails(Email, FullName) values(?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, name);
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

    //update user profile (UpdateProfileAction)
    public boolean updateProfile(String email, String name, int gender, Date birthdate,
            String phone, String address)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        java.sql.Date sqlBirthdate = new java.sql.Date(birthdate.getTime());
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update UserDetails set FullName = ?, "
                        + "Gender = ?, Birthdate = ?, Phone = ?, Address = ? where Email = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setInt(2, gender);
                stm.setDate(3, sqlBirthdate);
                stm.setString(4, phone);
                stm.setString(5, address);
                stm.setString(6, email);
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
}
