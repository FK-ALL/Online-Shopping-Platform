package dao;

import java.sql.*;

public class DoSetAddress {
    public boolean do_SetAddress(int user_Id, String newProvince, String newCity, String newDistrict, String newAddress)
            throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "insert into user_address (user_Id,province,city,district,address) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ps.setString(2, newProvince);
            ps.setString(3, newCity);
            ps.setString(4, newDistrict);
            ps.setString(5, newAddress);
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
