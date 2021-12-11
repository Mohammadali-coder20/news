package com.kahkeshan.ui.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/error.do")
public class ErrorController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = (String) req.getSession().getAttribute("errorType");
        req.setAttribute("message", message);
        req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,resp);
    }
}
