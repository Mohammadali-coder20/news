package com.kahkeshan.biz;

import com.kahkeshan.data.NewsData;
import com.kahkeshan.ui.models.News;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsService {
    public static boolean isFileSavedToDataBase(News news, InputStream is) throws SQLException, ClassNotFoundException {
        return NewsData.isFileSavedToDataBase(news,is);
    }

    public static List<News> loadAllNews() throws SQLException, ClassNotFoundException, IOException {
        return NewsData.loadAllNews();
    }

    public static int findNewsByID(News news) throws SQLException, ClassNotFoundException, IOException {
        return NewsData.findNewsByID(news);
    }

    public static boolean updateNews(News news) throws SQLException, ClassNotFoundException {
        return NewsData.updateNews(news);
    }

    public static boolean updateNews(News news, InputStream is) throws SQLException, ClassNotFoundException {
        return NewsData.updateNews(news,is);
    }

    public static boolean deleteNews(int id) throws SQLException, ClassNotFoundException {
        return NewsData.deleteNews(id);
    }
}
