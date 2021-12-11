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

@WebServlet("/delete-news.do")
public class DeleteNewsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int newsID = Integer.parseInt(req.getParameter("id"));
        User user =(User) req.getSession().getAttribute("user");
        int userID = user.getUserID();
        News news = new News();
        news.setId(newsID);
        try {
            int adminID = NewsService.findNewsByID(news);
            if (adminID == userID){
                if (NewsService.deleteNews(newsID)){
                    resp.sendRedirect("/user/load-news.do");
                }else{
                    resp.getWriter().print("something is wrong");
                }
            }else{
                req.getSession().setAttribute("errorType","you dont have permission");
                resp.sendRedirect("/error.do");
            }
        } catch (SQLException | ClassNotFoundException throwAbles) {
            throwAbles.printStackTrace();
            resp.sendRedirect("/error.do");
        }
    }
}
