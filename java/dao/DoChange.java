package dao;

import java.sql.*;

public class DoChange {
    public boolean do_Change(String table, String changeAttribute, String changeValue, int user_Id)
            throws SQLException {
        try {

            ConnectMysql connectMysql = new ConnectMysql();
            Connection conn = connectMysql.doConnect();
            if (conn != null) {

                String sql = "UPDATE " + table + " SET " + changeAttribute + "='" + changeValue + "' WHERE user_Id="
                        + user_Id;

                PreparedStatement ps = conn.prepareStatement(sql);

                /*
                 * ps.setString(1, table); ps.setString(2, "'" + changeAttribute + "'");
                 * ps.setString(3, changeValue);
                 */

                int i = ps.executeUpdate();

                if (i > 0) {
                    return true;
                } else

                    ps.close();
                conn.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
