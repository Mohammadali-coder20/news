package com.kahkeshan.ui.controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/load-visited-news-count.do")
public class LoadViewedCountNewsController extends HttpServlet {
    private static Map<Integer,Integer> map = new HashMap<>();

    public static Map<Integer, Integer> getMap() {
        return map;
    }

    public static void setMap(Map<Integer, Integer> map) {
        LoadViewedCountNewsController.map = map;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int newsId = Integer.parseInt(req.getParameter("id"));
        if (newsId == 0){
            req.getSession().setAttribute("errorType","please choose the right news");
            resp.sendRedirect("/error.do");
        }
        int newsViewed  = Integer.parseInt(req.getParameter("count"));
        newsViewed++;
        map.put(newsId,newsViewed);
        req.getServletContext().setAttribute("map",map);
        resp.getWriter().print(newsViewed);
    }
}
