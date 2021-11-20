package dao;

import java.sql.*;

public class DoUpdateOrder {
    public boolean do_CompleteOrder(int order_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "UPDATE order_master set receive_Time = ? where order_Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(1, ts);
            ps.setInt(2, order_Id);
            int i = ps.executeUpdate();
            if (i > 0) {
                // 为商品增加销量
                String sql2 = "select product_Id,productPurchaseNumber from order_master where order_Id = ? ";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, order_Id);
                ResultSet rs = ps2.executeQuery();
                rs.next();
                DoIncreaseSales dis = new DoIncreaseSales();
                dis.do_IncreaseSales(rs.getInt("product_Id"), rs.getInt("productPurchaseNumber"));

                ps2.close();
                rs.close();
                ps.close();
                conn.close();
                return true;
            }
            ps.close();
            conn.close();
            return false;

        }

        return false;

    }
}
