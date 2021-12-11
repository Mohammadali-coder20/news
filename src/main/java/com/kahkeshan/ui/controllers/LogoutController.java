package com.kahkeshan.ui.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") == null){
            req.getSession().setAttribute("errorType","you are not login");
            resp.sendRedirect("/error.do");
        }
        else{
            req.getSession().invalidate();
            resp.sendRedirect("/Home.do");
        }
    }
}
