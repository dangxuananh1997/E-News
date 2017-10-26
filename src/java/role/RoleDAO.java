package role;

/**
 * Created by nxa on 10/26/17.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import javax.naming.NamingException;
import utils.DBUtils;

public class RoleDAO {
    private ArrayList<String> roleNameList;

    public ArrayList<String> getRoleName(int role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if(con != null) {
                String sql = "SELECT RoleName FROM Role WHERE RoleID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, role);
                rs= stm.executeQuery();
                while(rs.next()) {
                    String roleName = rs.getString("RoleName");
                    if(this.roleNameList == null) {
                        this.roleNameList = new ArrayList<>();
                    }
                    roleNameList.add(roleName);
                }
            }
            return roleNameList;
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
