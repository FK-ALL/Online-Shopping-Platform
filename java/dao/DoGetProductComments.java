package dao;

import java.sql.*;
import java.util.*;

import beans.*;

public class DoGetProductComments {
    public List<Comment> do_GetProductComments(int product_Id) throws SQLException {
        ConnectMysql connectMysql = new ConnectMysql();
        Connection conn = connectMysql.doConnect();
        if (conn != null) {
            String sql = "select comment_Id,login_Name,content,audit_Time,audit_Status from product_comment where product_Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, product_Id);
            ResultSet rs = ps.executeQuery();
            if (!rs.isBeforeFirst()) {
                ps.close();
                rs.close();
                conn.close();
                return null;
            } else {
                List<Comment> comments = new ArrayList<Comment>();
                while (rs.next()) {

                    if (rs.getInt("audit_Status") == 1) {
                        Comment comment = new Comment(rs.getInt("comment_Id"));
                        comment.setLogin_Name(rs.getString("login_Name"));
                        comment.setContent(rs.getString("content"));
                        comment.setAudit_Time(rs.getDate("audit_Time"));

                        comments.add(comment);
                    }
                }

                ps.close();
                rs.close();
                conn.close();
                return comments;
            }
        }
        return null;
    }
}