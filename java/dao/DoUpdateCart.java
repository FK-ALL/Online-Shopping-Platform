package dao;

import java.sql.*;

public class DoUpdateCart {
    public boolean do_UpdateCart(int user_Id, int product_Id, int purchaseNumber) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select cart_Id,product_amount from order_cart where user_Id = ? and product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ps.setInt(2, product_Id);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                String sql2 = "insert into order_cart (user_Id,product_Id,product_amount) values (?,?,?)";
                PreparedStatement ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, user_Id);
                ps2.setInt(2, product_Id);
                ps2.setInt(3, purchaseNumber);
                int i = ps2.executeUpdate();
                System.out.print("1");
                if (i > 0) {
                    ps.close();
                    rs.close();
                    ps2.close();
                    conn.close();
                    return true;
                } else {
                    ps.close();
                    rs.close();
                    ps2.close();
                    conn.close();
                    return false;
                }
            } else {
                rs.next();
                String sql3 = "UPDATE order_cart set product_amount=" + (rs.getInt("product_amount") + purchaseNumber)
                        + " where cart_Id = ?";
                PreparedStatement ps3 = conn.prepareStatement(sql3);
                ps3.setInt(1, rs.getInt("cart_Id"));
                int i = ps3.executeUpdate();
                if (i > 0) {
                    ps.close();
                    rs.close();
                    ps3.close();
                    conn.close();
                    return true;
                } else {
                    ps.close();
                    rs.close();
                    ps3.close();
                    conn.close();
                    return false;
                }
            }

        }

        return false;

    }

    public boolean do_DeleteCart(int user_Id, int product_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "delete from order_cart where user_Id = ? and product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ps.setInt(2, product_Id);
            int i = ps.executeUpdate();
            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            } else {
                ps.close();
                conn.close();
                return false;
            }
        }

        return false;
    }

    public boolean do_UpdatePurchaseNumber(int user_Id, int product_Id, int purchaseNumber) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "UPDATE order_cart set product_amount=" + purchaseNumber
                    + " where user_Id = ? and product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ps.setInt(2, product_Id);
            int i = ps.executeUpdate();
            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            } else {
                ps.close();
                conn.close();
                return false;
            }
        }
        return false;
    }

    public boolean do_ClearPurchaseCart(int user_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "delete from order_cart where user_Id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            int i = ps.executeUpdate();
            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            } else {
                ps.close();
                conn.close();
                return false;
            }
        }
        return false;
    }
}
