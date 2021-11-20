package dao;

import java.sql.*;
import java.util.*;

public class DoGetIdMap {
    public List do_GetIdMap() throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {

            List idMap = new ArrayList<>();
            String sql = "select brand_Id,brand_Name,brand_Status from brand_information";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                Map<Integer, String> brandMap = new HashMap<Integer, String>();
                while (rs.next()) {
                    if (rs.getInt("brand_Status") == 1) {
                        brandMap.put(rs.getInt("brand_Id"), rs.getString("brand_Name"));
                    }
                }
                idMap.add(brandMap);
            }

            String sql2 = "select category_Id,category_Name,parent_Id,category_Status from product_category";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            if (!rs2.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                Map<Integer, String> categoryMap = new HashMap<Integer, String>();
                Map<Integer, Integer> categoryParentMap = new HashMap<Integer, Integer>();
                while (rs2.next()) {
                    if (rs2.getInt("category_Status") == 1) {
                        categoryMap.put(rs2.getInt("category_Id"), rs2.getString("category_Name"));
                        categoryParentMap.put(rs2.getInt("category_Id"), rs2.getInt("parent_Id"));

                    }
                }
                idMap.add(categoryMap);
                idMap.add(categoryParentMap);

            }
            return idMap;
        }
        return null;
    }
}
