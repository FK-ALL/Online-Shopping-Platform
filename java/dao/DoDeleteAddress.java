package dao;

import java.sql.*;

public class DoDeleteAddress {
    public boolean do_DeleteAddress(int user_address_id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "delete from user_address where user_address_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_address_id);
            int i = ps.executeUpdate();
            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            }
            ps.close();
            conn.close();

        }
        return false;
    }
}
