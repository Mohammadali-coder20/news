<%@ page import="com.kahkeshan.ui.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/13/2021
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<c:choose>--%>
<%--    <c:when test="${sessionScope.user eq ''}">--%>
<%--        <%@page session="false"%>--%>
<%--    </c:when>--%>
<%--    <c:otherwise></c:otherwise>--%>
<%--</c:choose>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <script type="application/javascript" src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
    <div class="content">
    <form action="/save/users.do" method="get">
        <fieldset>
            <c:choose>
                <c:when test="${mode eq 'adduser'}">
                    <legend>Add user</legend>
                    <label>Name:</label>
                    <div><input type="text" name="name"/></div><br/>
                    <label>Family:</label>
                    <div><input type="text" name="family"/></div><br/>
                    <label>Role:</label>
                    <div>
                        <select name="role">
                            <option value="admin">Admin</option>
                            <option value="user">User</option>
                        </select>
                    </div><br/>
                    <label>Username:</label>
                    <div><input type="text" name="username"/></div><br/>
                    <label>Password:</label>
                    <div><input type="password" name="password"/></div><br/>
                    <div><input type="submit" value="Add new user"/></div><br/>
                    <a href="/admin/Panel.do"><input type="button" value="Back to panel"/></a>
                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <legend>Edit Profile</legend>
                        </c:when>
                        <c:otherwise>
                            <legend>register</legend>
                        </c:otherwise>
                    </c:choose>
                    <label>Name:</label>
                    <div><input type="text" name="name" value="${sessionScope.user.name}"/></div><br/>
                    <label>Family:</label>
                    <div><input type="text" name="family" value="${user.family}"/></div><br/>
                    <label>Role:</label>
                    <div>
                        <select name="role">
                            <c:choose>
                                <c:when test="${sessionScope.user.admin }">
                                    <option value="admin">Admin</option>
                                    <option value="user">User</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="user">User</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div><br/>
                    <label>Username:</label>
                    <div><input type="text" name="username" value="${user.userName}"/></div><br/>
                    <label>Password:</label>
                    <div><input type="password" name="password" value="${user.passWord}"/></div><br/>
                    <c:choose>
                        <c:when test="${ not empty sessionScope.user}">
                            <div><input type="submit" value="Edit profile"/></div>
                        </c:when>
                        <c:otherwise>
                            <div><input type="submit" value="Register"/></div>
                        </c:otherwise>
                    </c:choose><br/>
                    <c:choose>
                        <c:when test="${sessionScope.user.admin}">
                            <a href="/admin/Panel.do"><input type="button" value="Back to panel"/></a>
                        </c:when>
                        <c:otherwise>
                            <a href="/user/Panel.do"><input type="button" value="Back to panel"/></a>
                        </c:otherwise>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </fieldset>
    </form>
    </div>
</body>
</html>
