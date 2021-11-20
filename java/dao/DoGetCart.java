package dao;

import java.sql.*;
import java.util.*;

import beans.*;

public class DoGetCart {
    public List<CartProduct> do_GetCart(int user_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select product_Id,product_amount from order_cart where user_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                List<CartProduct> cartProducts = new ArrayList<CartProduct>();
                DoGetProduct dgp = new DoGetProduct();
                while (rs.next()) {
                    CartProduct cartProduct = new CartProduct();
                    cartProduct.setProduct(dgp.do_GetProduct(rs.getInt("product_Id")));
                    cartProduct.setAmount(rs.getInt("product_amount"));

                    cartProducts.add(cartProduct);
                }
                ps.close();
                rs.close();
                conn.close();
                return cartProducts;
            }
        }
        return null;

    }

}
