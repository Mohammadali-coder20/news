<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/13/2021
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <script type="application/javascript" src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body id="panelPage">
    <div style="background-color: whitesmoke; width: 500px; height: auto; position: relative; top: 163px; margin: auto">
       <div style="padding-top: 32px;">
           Hi ${user.name} ${user.family},Welcome to your ${user.role} page <br/><br/>
           <a href="/admin/add-news.do"><input type="button" value="Add new news"></a><br/><br/>
           <a href="/user/load-news.do"><input type="button" value="Show News"></a><br/><br/>
           <a href="/user/edit-profile.do"> <input type="button" value="Edit profile"></a><br/><br/>
           <a href="/admin/add-user.do"><input type="button" value="Add user"></a><br/><br/>
           <a href="/logout.do"><input type="button" value="Logout"></a><br/><br/>
       </div>
    </div>
</body>
</html>
