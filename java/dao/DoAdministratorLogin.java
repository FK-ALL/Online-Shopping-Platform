package dao;

import java.sql.*;

import beans.*;

public class DoAdministratorLogin {
    public Administrator do_AdministratorLogin(String administrator_RealName, String administrator_Password,
            String administrator_IDCode) throws SQLException {

        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select * from administrators_information where administrator_RealName = ? and administrator_Password = ? and administrator_IDCode = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, administrator_RealName);
            ps.setString(2, administrator_Password);
            ps.setString(3, administrator_IDCode);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                rs.next();
                Administrator administrator = new Administrator();
                administrator.setAdministrator_Id(rs.getInt("administrator_id"));
                administrator.setAdministrator_RealName(rs.getString("administrator_RealName"));
                administrator.setAdministrator_Password(rs.getString("administrator_Password"));
                administrator.setAdministrator_IDCode(rs.getString("administrator_IDCode"));
                administrator.setIdentity_CardType(rs.getInt("identity_CardType"));
                administrator.setIdentity_CardNumber(rs.getString("identity_CardNumber"));
                administrator.setAdministrator_Phone(rs.getInt("administrator_Phone"));
                ps.close();
                rs.close();
                conn.close();
                return administrator;

            }

        }

        return null;

    }
}
