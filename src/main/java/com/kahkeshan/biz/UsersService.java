package com.kahkeshan.biz;

import com.kahkeshan.data.UsersData;
import com.kahkeshan.ui.models.News;
import com.kahkeshan.ui.models.User;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.SQLException;

public class UsersService{


    public  static int saveUser(User user) throws SQLException, ClassNotFoundException {
         return UsersData.saveUser(user);
    }

    public static boolean isValidUser(User user) throws SQLException, ClassNotFoundException {
        return UsersData.isValidUser(user);
    }

    public static boolean editProfile(User user) throws SQLException, ClassNotFoundException {
        return UsersData.editProfile(user);
    }

    public static boolean checkTheRole(User user) throws SQLException, ClassNotFoundException {
        return UsersData.checkTheRole(user);
    }
}
