package dao;

import java.sql.*;

public class DoDeleteProduct {
    public boolean do_DeleteProduct(int product_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "delete from product_information where product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_Id);
            int i = ps.executeUpdate();
            String sql1 = "delete from product_picture_information where product_Id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, product_Id);
            int j = ps1.executeUpdate();

            if (i > 0 && j > 0) {
                ps.close();
                conn.close();
                return true;
            }
            ps.close();
            conn.close();

        }

        return false;
    }

    public boolean do_DeleteUpdateProduct(int product_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "delete from product_information where product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_Id);
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
