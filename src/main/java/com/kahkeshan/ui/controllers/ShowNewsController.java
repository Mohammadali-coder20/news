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

@WebServlet("/show-full-news.do")
public class ShowNewsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        news.setId(Integer.parseInt(req.getParameter("id")));
        try {
            NewsService.findNewsByID(news);
            req.setAttribute("news",news);
            req.getRequestDispatcher("/WEB-INF/show-full-news.jsp").forward(req,resp);
        } catch (SQLException | ClassNotFoundException throwAbles) {
            throwAbles.printStackTrace();
            resp.sendRedirect("/error.do");
        }
    }
}
