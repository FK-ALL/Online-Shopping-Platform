package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

import beans.*;

public class DoAddOrder {
    public boolean do_AddOrder(List<CartProduct> cartProducts, User user, String address) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            int user_Id = user.getUser_Id();
            String user_RealName = user.getUser_RealName();
            int i = 0;
            for (i = 0; i < cartProducts.size(); i++) {
                String sql = "insert into order_master (user_Id,user_RealName,address,payment_Method, order_Money,creat_Time,order_Status,product_Id,product_Name,productPurchaseNumber) values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, user_Id);
                ps.setString(2, user_RealName);
                ps.setString(3, address);
                ps.setInt(4, 5);
                ps.setBigDecimal(5, BigDecimal
                        .valueOf(cartProducts.get(i).getProduct().getPrice() * cartProducts.get(i).getAmount()));
                Timestamp ts = new Timestamp(System.currentTimeMillis());
                ps.setTimestamp(6, ts);
                ps.setInt(7, 1);
                ps.setInt(8, cartProducts.get(i).getProduct().getProduct_Id());
                ps.setString(9, cartProducts.get(i).getProduct().getProduct_Name());
                ps.setInt(10, cartProducts.get(i).getAmount());
                int j = ps.executeUpdate();
                if (j > 0) {
                    ps.close();
                    continue;
                } else {
                    ps.close();
                    break;
                }

            }

            if (i == cartProducts.size()) {
                DoUpdateCart duc = new DoUpdateCart();
                if (duc.do_ClearPurchaseCart(user_Id)) {
                    conn.close();
                    return true;
                } else {
                    conn.close();
                    return false;
                }

            }

            else {
                conn.close();
                return false;
            }
        }
        return false;

    }
}
