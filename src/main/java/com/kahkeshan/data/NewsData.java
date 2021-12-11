package com.kahkeshan.data;

import com.kahkeshan.biz.MyConnectorToDb;
import com.kahkeshan.ui.models.News;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsData {
    public static boolean isFileSavedToDataBase(News news, InputStream is) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO news (subject , title , body , image, adminid, date) VALUES (? , ? , ? , ?, ?, ?)");
        preparedStatement.setString(1,news.getSubject());
        preparedStatement.setString(2,news.getTitle());
        preparedStatement.setString(3,news.getBody());
        preparedStatement.setBlob(4,is);
        preparedStatement.setInt(5,news.getAdminId());
        preparedStatement.setString(6,news.getNewsDate());
        return preparedStatement.executeUpdate() > 0;
    }

    public static List<News> loadAllNews() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = MyConnectorToDb.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("Select * from news order by id");
        List<News> newsList = new ArrayList<>();
        while (rs.next()){
            newsList.add(new News(rs.getString(2),rs.getString(3),rs.getString(4),rs.getBlob(5),rs.getInt(1),rs.getInt(6),rs.getString(7)));
        }
        return newsList;
    }

    public static int findNewsByID(News news) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement =  connection.prepareStatement("SELECT * from news where id = ?");
        preparedStatement.setInt(1,news.getId());
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            news.setSubject(rs.getString(2));
            news.setTitle(rs.getString(3));
            news.setBody(rs.getString(4));
            news.setImg(rs.getBlob(5));
            news.setAdminId(rs.getInt(6));
        }
        return news.getAdminId();
    }

    public static boolean updateNews(News news) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE news set subject=? , title=? , body=? where (id=?)");
        preparedStatement.setString(1, news.getSubject());
        preparedStatement.setString(2, news.getTitle());
        preparedStatement.setString(3, news.getBody());
        preparedStatement.setInt(4,news.getId());
        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean updateNews(News news, InputStream is) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("UPDATE news set subject=? , title=? , body=?, image=? where (id=?)");
        preparedStatement.setString(1, news.getSubject());
        preparedStatement.setString(2, news.getTitle());
        preparedStatement.setString(3, news.getBody());
        preparedStatement.setBlob(4,is);
        preparedStatement.setInt(5,news.getId());
        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean deleteNews(int id) throws SQLException, ClassNotFoundException {
        Connection connection = MyConnectorToDb.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Delete from news where id=?");
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate() > 0;
    }
}
