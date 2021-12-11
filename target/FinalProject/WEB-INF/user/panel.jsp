<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/13/2021
  Time: 12:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Panel</title>
    <script type="application/javascript" src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body id="panelPage">
    <div style="background-color: whitesmoke; width: 500px; height: auto; position: relative; top: 163px; margin: auto">
        <div style="padding-top: 32px;padding-bottom: 38px;">
            Hi ${user.name} ${user.family},Welcome to your ${user.role} page <br/><br/>
            <a href="/user/load-news.do"><button>Show News</button></a><br/><br/>
            <a href="/user/edit-profile.do"><button>Edit profile</button></a><br/><br/>
            <a href="/logout.do"><button>Logout</button></a><br/><br/>
        </div>
    </div>
</body>
</html>
