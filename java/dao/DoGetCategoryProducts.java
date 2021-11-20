package dao;

import java.sql.*;
import java.util.*;

public class DoGetCategoryProducts {
    public List<Integer> do_GetCategoryProducts(int categoryId) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select product_Id from product_information where (first_CategoryId = ? or second_CategoryId = ? or third_CategoryId = ?) order by sales";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, categoryId);
            ps.setInt(2, categoryId);
            ps.setInt(3, categoryId);

            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {

                List<Integer> pids = new ArrayList<Integer>();
                while (rs.next()) {
                    pids.add(rs.getInt("product_Id"));
                }
                ps.close();
                rs.close();
                conn.close();
                return pids;
            }

        }
        return null;
    }
}
