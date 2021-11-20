package dao;

import java.sql.*;

public class ConnectMysql {
    public Connection doConnect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/online_pharmacy?characterEncoding=UTF-8";
            String userName = "root";
            String passWord = "root";
            Connection conn = DriverManager.getConnection(url, userName, passWord);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
