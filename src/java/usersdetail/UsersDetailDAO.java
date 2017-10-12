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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Administrator
 */
public class UsersDetailDAO implements Serializable {

    //list of user details
    private List<UsersDetailDTO> details = null;

    public List<UsersDetailDTO> getDetailsList() {
        return details;
    }

    //get user details
    public void getUsersDetail(String email)
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
                    if (this.details == null) {
                        this.details = new ArrayList<>();
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
                if(row > 0){
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
