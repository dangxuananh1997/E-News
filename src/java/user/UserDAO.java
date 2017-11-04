package user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import utils.DBUtils;

public class UserDAO implements Serializable {
    //get password (NewPasswordAction)
    public String getPassword(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String password = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select Password from [User] where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    password = rs.getString("Password");
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
        return password;
    }    
    //check if user account exists in database (LoginAction)
    public boolean checkLogin(String email, String password)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * from [User] where Email = ? and Password = ? ";
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

    //get user role (LoginAction)
    public int getRole(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int role = 0;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select RoleID from [User] where Email = ?";
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

    //get user status (LoginAction)
    public boolean isActive(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select IsActive from [User] where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    boolean isActive = rs.getBoolean("IsActive");
                    return isActive;
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
    
    
    //check if email already exists in database (RegisterAction)
    public boolean checkEmail(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select Email from [User] where Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
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
    //create new user account (RegisterAction)

    public boolean createAccount(String email, String password, int roleID)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sqlUsers = "Insert into [User](Email, Password, RoleID, isActive) values(?,?,?,?)";
                stm = con.prepareStatement(sqlUsers);
                stm.setString(1, email);
                stm.setString(2, password);
                stm.setInt(3, roleID);
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

    //change user password (UpdateProfileAction)
    public boolean updatePassword(String email, String newPassword)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update [User] set Password = ? where Email = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, newPassword);
                stm.setString(2, email);
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

//    private ArrayList<String> authorNameList;   //List of authors (SearchArticleAction / 
//                                                                  ViewByCategoryAction /
//                                                                  ViewHomeAction)

    /* Ban users */
    public boolean banUser(String email) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE [User] SET IsActive = ? WHERE Email = ?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, false);
                stm.setString(2, email);
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
    
    /* Unban users */
    public boolean unbanUser(String email) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "UPDATE [User] SET IsActive = ? WHERE Email = ?";
                stm = con.prepareStatement(sql);
                stm.setBoolean(1, true);
                stm.setString(2, email);
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

    /* get role id by email */
    private ArrayList<Integer> roleIDList;

    public void getRoleID(String email) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT RoleID FROM User WHERE Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roleID = rs.getInt("RoleID");
                    if (this.roleIDList == null) {
                        this.roleIDList = new ArrayList<>();
                    }
                    roleIDList.add(roleID);
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
