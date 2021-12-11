package com.kahkeshan.data;

import com.kahkeshan.biz.MyConnectorToDb;
import com.kahkeshan.ui.models.News;
import com.kahkeshan.ui.models.User;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.*;

public class UsersData {

    public static int saveUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (name,family,username,password,admin_role) VALUES (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getFamily());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassWord());
        preparedStatement.setBoolean(5, user.isAdmin());
        return preparedStatement.executeUpdate();
    }

    public static boolean isValidUser(User user) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where (username=?) AND (password=?)");
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassWord());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            user.setUserID(rs.getInt(1));
            user.setName(rs.getString(2));
            user.setFamily(rs.getString(3));
            user.setUserName(rs.getString(4));
            user.setPassWord(rs.getString(5));
            user.setAdmin(rs.getBoolean(6));
            return true;
        }else
            return false;
    }

    public static boolean editProfile(User user) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user set name=? , family=? , username=? , password=? where (id=?)");
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getFamily());
        preparedStatement.setString(3,user.getUserName());
        preparedStatement.setString(4,user.getPassWord());
        preparedStatement.setInt(5,user.getUserID());
        return preparedStatement.executeUpdate() > 0 ;
    }

    public static boolean checkTheRole(User user) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select admin_role from user where (id=?)");
        preparedStatement.setInt(1,user.getUserID());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            return rs.getBoolean(1);
        }
        return false;
    }
}
