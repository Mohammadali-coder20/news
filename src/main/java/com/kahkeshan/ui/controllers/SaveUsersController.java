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

@WebServlet("/save/users.do")
public class SaveUsersController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String family = req.getParameter("family");
        String role = req.getParameter("role");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = (User) req.getSession().getAttribute("user");
        User user = new User(name, family, username, password, role);
        try {
            if (loginUser == null) {
                if (UsersService.saveUser(user) > 0)
                    resp.sendRedirect("/Home.do");
                else {
                    req.getSession().setAttribute("errorType", "you have not registered complete");
                    resp.sendRedirect("/error.do");
                }
            } else {
                if (role.equalsIgnoreCase("admin") && !loginUser.isAdmin()) {
                    req.getSession().setAttribute("errorType", "you cant change your role to admin");
                    resp.sendRedirect("/error.do");
                }
                String mode = (String) req.getSession().getAttribute("mode");
                if (mode != null) {
                    if (mode.equals("adduser")) {
                        if (UsersService.saveUser(user) > 0) {
                            resp.sendRedirect("/admin/Panel.do");
                            req.getSession().setAttribute("mode", null);
                        } else {
                            req.getSession().setAttribute("errorType", "the user have not registered complete");
                            resp.sendRedirect("/error.do");
                        }
                    }
                } else {
                    user.setUserID(loginUser.getUserID());
                    if (UsersService.editProfile(user)) {
                        req.getSession().setAttribute("user", user);
                        if (loginUser.isAdmin())
                            resp.sendRedirect("/admin/Panel.do");
                        else
                            resp.sendRedirect("/user/Panel.do");
                    } else {
                        req.getSession().setAttribute("errorType", "you have not change any things");
                        resp.sendRedirect("/error.do");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            resp.sendRedirect("/error.do");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
