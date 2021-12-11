package com.kahkeshan.ui.controllers;

import com.kahkeshan.biz.NewsService;
import com.kahkeshan.biz.UsersService;
import com.kahkeshan.ui.models.News;
import com.kahkeshan.ui.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

@WebServlet("/save/news.do")
@MultipartConfig(maxFileSize = 16177215)
public class SaveNewsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String subject = req.getParameter("subject");
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        String newsId = req.getParameter("id");
        User user = (User) req.getSession().getAttribute("user");
        int adminID = 0;
        Part filePart = req.getPart("img");
        if (newsId.equals("")) {
            try {
                boolean adminRole = UsersService.checkTheRole(user);
                if (adminRole)
                    adminID = user.getUserID();
                else {
                    req.getSession().setAttribute("errorType", "you dont have permission");
                    resp.sendRedirect("/error.do");
                }
                News news = new News(subject, title, body, adminID);

                if (NewsService.isFileSavedToDataBase(news, News.partToStream(filePart))) {
                    resp.sendRedirect("/user/load-news.do");
                    System.out.println("file is saved");
                } else{
                    req.getSession().setAttribute("errorType","sorry the image is not saved in db");
                    resp.sendRedirect("/error.do");
                }
            } catch (SQLException | ClassNotFoundException throwAbles) {
                throwAbles.printStackTrace();
                resp.sendRedirect("/error.do");
            }
        } else {
            News news = new News(subject, title, body);
            news.setId(Integer.parseInt(newsId));
            try {
                if (filePart.getSize() == 0) {
                    if (NewsService.updateNews(news)) {
                        resp.sendRedirect("/user/load-news.do");
                    }
                } else {
                    if (NewsService.updateNews(news, News.partToStream(filePart))) {
                        resp.sendRedirect("/user/load-news.do");
                    }
                }
            } catch (SQLException | ClassNotFoundException throwAbles) {
                throwAbles.printStackTrace();
                resp.sendRedirect("/error.do");
            }
        }

    }
}
