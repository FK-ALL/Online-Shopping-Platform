package dao;

import java.sql.*;

public class DoRegister {
    public boolean do_Register(String login_Name, String login_Password) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "insert into user_login (login_Name,login_Password) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login_Name);
            ps.setString(2, login_Password);
            int i = ps.executeUpdate();
            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            }
            ps.close();

        }
        conn.close();
        return false;
    }

    public boolean do_CheckLoginName(String login_Name) throws SQLException {

        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select login_Name from user_login where login_Name = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login_Name);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return false;
            }
        }
        return false;
    }
}