package role;

/**
 * Created by nxa on 10/26/17.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

public class RoleDAO {
    public String getRoleName(String email)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String roleName = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select RoleName FROM Role r, [User] u where r.RoleID = u.RoleID AND u.Email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    roleName = rs.getString("RoleName");
                }
            }
            return roleName;
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
