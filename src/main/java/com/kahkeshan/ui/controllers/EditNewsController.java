package com.kahkeshan.ui.controllers;

import com.kahkeshan.biz.NewsService;
import com.kahkeshan.ui.models.News;
import com.kahkeshan.ui.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit-news.do")
public class EditNewsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        News news = new News();
        int newsID = Integer.parseInt(req.getParameter("id"));
        news.setId(newsID);
        User user = (User) req.getSession().getAttribute("user");
        int userID = user.getUserID();
        try {
            int adminID = NewsService.findNewsByID(news);
            req.setAttribute("mode", "edit");
            if (userID == adminID) {
                req.setAttribute("news", news);
                req.getRequestDispatcher("/WEB-INF/admin/save-news.jsp").forward(req, resp);
            } else{
                req.getSession().setAttribute("errorType","you dont have permission");
                resp.sendRedirect("/error.do");
            }
        } catch (SQLException | ClassNotFoundException throwAbles) {
            throwAbles.printStackTrace();
        }
    }
}
