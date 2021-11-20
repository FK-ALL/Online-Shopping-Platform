package dao;

import java.sql.*;
import java.util.*;

import beans.*;

public class DoAddComment {
    public boolean do_AddComment(int product_Id, int user_Id, String login_Name, String newComment)
            throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "insert into product_comment (product_Id,user_Id,login_Name,content,audit_Time) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_Id);
            ps.setInt(2, user_Id);
            ps.setString(3, login_Name);
            ps.setString(4, newComment);
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(5, ts);

            int i = ps.executeUpdate();
            if (i > 0) {
                ps.close();
                conn.close();
                return true;
            }
            ps.close();
            conn.close();

        }
        return false;

    }
}
