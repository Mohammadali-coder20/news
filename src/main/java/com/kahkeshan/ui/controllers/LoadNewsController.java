package com.kahkeshan.ui.controllers;

import com.kahkeshan.biz.NewsService;
import com.kahkeshan.ui.models.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet("/user/load-news.do")
public class LoadNewsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<News> newsArrayList = NewsService.loadAllNews();
            Collections.reverse(newsArrayList);
            req.setAttribute("newsList",newsArrayList);
            req.getRequestDispatcher("/WEB-INF/show-news.jsp").forward(req,resp);
        } catch (SQLException | ClassNotFoundException throwAbles) {
            throwAbles.printStackTrace();
            resp.sendRedirect("error.do");
        }
    }
}
