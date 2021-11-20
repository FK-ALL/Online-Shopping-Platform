package dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DoGetAddress {
    public Map<String, Map<Integer, String>> do_GetAddress(int user_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select user_address_id,province,city,district,address,is_Default from user_address where user_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_Id);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                Map<String, Map<Integer, String>> map = new HashMap<String, Map<Integer, String>>();
                Map<Integer, String> province = new HashMap<Integer, String>();
                Map<Integer, String> city = new HashMap<Integer, String>();
                Map<Integer, String> district = new HashMap<Integer, String>();
                Map<Integer, String> address = new HashMap<Integer, String>();
                Map<Integer, String> is_Default = new HashMap<Integer, String>();

                while (rs.next()) {
                    province.put(rs.getInt("user_address_id"), rs.getString("province"));
                    city.put(rs.getInt("user_address_id"), rs.getString("city"));
                    district.put(rs.getInt("user_address_id"), rs.getString("district"));
                    address.put(rs.getInt("user_address_id"), rs.getString("address"));
                    is_Default.put(rs.getInt("user_address_id"), rs.getInt("is_Default") + "");
                }
                map.put("province", province);
                map.put("city", city);
                map.put("district", district);
                map.put("address", address);
                map.put("is_Default", is_Default);
                ps.close();
                rs.close();
                conn.close();
                return map;
            }
        }

        return null;// 暂时 错误页面
    }
}
