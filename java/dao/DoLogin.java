package dao;

import java.sql.*;

import beans.User;

public class DoLogin {
    public User do_Login(String login_Name, String login_Password) throws SQLException {

        try {

            ConnectMysql connectMysql = new ConnectMysql();
            Connection conn = connectMysql.doConnect();
            if (conn != null) {
                String sql = "select * from user_login where login_Name = ? and login_Password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, login_Name);
                ps.setString(2, login_Password);
                ResultSet rs = ps.executeQuery();
                if (!rs.isBeforeFirst()) {
                    ps.close();
                    rs.close();
                    conn.close();
                    return null;
                } else {
                    rs.next();

                    User user = new User(rs.getInt("user_Id"), rs.getString("login_Name"));
                    user.setlogin_Password(rs.getString("login_Password"));
                    user.setUser_Status(rs.getInt("user_Status"));

                    String sql2 = "select * from user_information where user_Id = " + rs.getInt("user_Id");
                    Statement stat = conn.createStatement();
                    ResultSet uirs = stat.executeQuery(sql2); // user_InfprmationResultSet

                    if (uirs.isBeforeFirst()) {
                        uirs.next();
                        user.setUser_RealName(
                                uirs.getString("user_RealName") == null ? "" : uirs.getString("user_RealName"));

                        user.setUser_Sex(uirs.getString("user_Sex") == null ? "" : uirs.getString("user_Sex"));
                        user.setIdentity_CardType(uirs.getString("identity_CardType"));
                        user.setIdentity_CardNumber(uirs.getString("identity_CardNumber") == null ? ""
                                : uirs.getString("identity_CardNumber"));
                        user.setUser_Phone(uirs.getString("user_Phone") == null ? "" : uirs.getString("user_Phone"));

                    }

                    else if (!uirs.isBeforeFirst()) {
                        String sql3 = "insert into user_information (user_Id) values (?)";
                        PreparedStatement ps2 = conn.prepareStatement(sql3);
                        ps2.setInt(1, rs.getInt("user_Id"));
                        ps2.executeUpdate();
                        ps2.close();
                    }

                    ps.close();
                    stat.close();
                    uirs.close();
                    conn.close();
                    return user;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
