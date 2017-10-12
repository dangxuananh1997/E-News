package user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

public class UserDAO implements Serializable {

    //check if user account exists in database
    public boolean checkLogin(String email, String password)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from [Users] where Email = ? and Password = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
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
    //get user role
    public int getRole(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int role = 0;
        
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select RoleID from [Users] where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    role = rs.getInt("RoleID");
                    return role;
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
        return role;
    }
    
    //create new user account
    public boolean createAccount(String email, String password)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sqlUsers = "Insert into [Users](Email, Password, RoleID) values(?,?,?)";
                stm = con.prepareStatement(sqlUsers);
                stm.setString(1, email);
                stm.setString(2, password);
                stm.setInt(3, 1);
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
