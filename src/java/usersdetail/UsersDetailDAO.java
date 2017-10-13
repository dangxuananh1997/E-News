/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.StringTokenizer;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
public class UsersDetailDAO implements Serializable {

    //get user details
    public UsersDetailDTO getUserDetails(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from UsersDetail where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    String name = rs.getString("FullName");
                    String gender = rs.getString("Gender");
                    String birthdate = rs.getDate("Birthdate") + "";
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    String image = rs.getString("Profile Image");
                    
                    StringTokenizer stk = new StringTokenizer(birthdate, "-");
                    int year = Integer.parseInt(stk.nextToken());
                    int month = Integer.parseInt(stk.nextToken());
                    int day = Integer.parseInt(stk.nextToken());
                    
                    UsersDetailDTO user = new UsersDetailDTO(email, name, gender, day, month, year, address, phone, image);
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

    //insert email and fullname into database
    public boolean insertEmailAndFullName(String email, String name)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Insert into UsersDetail(Email, FullName) values(?,?)";
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

    //update user profile
    public boolean updateProfile(String email, String name, String gender, Date birthdate,
            String phone, String address)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        java.sql.Date sqlBirthdate = new java.sql.Date(birthdate.getTime());
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update UsersDetail set FullName = ?, "
                        + "Gender = ?, Birthdate = ?, Phone = ?, Address = ? where Email = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, gender);
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
