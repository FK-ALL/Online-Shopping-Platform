package dao;

import java.sql.*;
import java.util.*;

public class DoSearchProduct {
    public List<Integer> do_SearchProduct(String productName) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {

            String[] words = productName.split(" ");
            List<Integer> pids = new ArrayList<Integer>();
            for (String w : words) {

                String sql = "select product_Id from product_information where product_Name like ? or product_Core like ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + w + "%");
                ps.setString(2, "%" + w + "%");

                ResultSet rs = ps.executeQuery();
                if (rs.isBeforeFirst()) {
                    while (rs.next()) {
                        if (!pids.contains(rs.getInt("product_Id")))
                            pids.add(rs.getInt("product_Id"));
                    }

                }

            }

            conn.close();
            return pids;
        }
        return null;
    }
}
