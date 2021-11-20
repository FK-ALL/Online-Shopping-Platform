package dao;

import java.sql.*;

public class DoIncreaseSales {
    public boolean do_IncreaseSales(int product_Id, int productPurchaseNumber) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select sales from product_information where product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_Id);
            ResultSet rs = ps.executeQuery();
            if (rs.isBeforeFirst()) {
                rs.next();
                String sql2 = "update product_information set sales = ? where product_Id = ?";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, rs.getInt("sales") + productPurchaseNumber);
                ps2.setInt(2, product_Id);
                int i = ps2.executeUpdate();

                conn.close();
                ps.close();
                rs.close();
                ps2.close();
                if (i > 0)
                    return true;
                else
                    return false;
            }

        }
        conn.close();
        return false;
    }
}
