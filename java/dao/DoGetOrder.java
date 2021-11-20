package dao;

import java.sql.*;
import java.util.*;
import beans.*;

public class DoGetOrder {
    public List<Order> do_GetOrder(int user_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select order_Id,product_Id,user_RealName,address,order_Money,creat_Time,receive_Time,product_Name,productPurchaseNumber from order_master where user_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                List<Order> orders = new ArrayList<Order>();
                while (rs.next()) {
                    Order order = new Order(rs.getInt("order_Id"), rs.getInt("product_Id"),
                            rs.getString("user_RealName"), rs.getString("address"), rs.getBigDecimal("order_Money"),
                            rs.getTimestamp("creat_Time"), rs.getTimestamp("receive_Time"),
                            rs.getString("product_Name"), rs.getInt("productPurchaseNumber"));

                    orders.add(order);
                }
                ps.close();
                rs.close();
                conn.close();
                return orders;
            }
        }
        return null;
    }
}
