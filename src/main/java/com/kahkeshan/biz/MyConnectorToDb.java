package com.kahkeshan.biz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnectorToDb {

    private static String DriverPath = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/kahkeshan";
    private static String username = "root";
    private static String password = "13792000";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DriverPath);
        Connection connection = DriverManager.getConnection(url,username,password);
        return connection;
    }

}
