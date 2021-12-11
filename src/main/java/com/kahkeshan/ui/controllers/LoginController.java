package com.kahkeshan.ui.controllers;

import com.kahkeshan.biz.UsersService;
import com.kahkeshan.ui.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username,password);

        try {
            if (UsersService.isValidUser(user)){
                req.getSession().setAttribute("user",user);
                if (user.isAdmin()){
                    resp.sendRedirect("/admin/Panel.do");
                }else
                    resp.sendRedirect("/user/Panel.do");
            }else {
                req.getSession().setAttribute("errorType"," please login first");
                resp.sendRedirect("/error.do");
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
