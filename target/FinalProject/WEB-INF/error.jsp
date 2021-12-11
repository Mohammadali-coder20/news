<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/22/2021
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error Page</title>
    <script type="application/javascript" src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body id="errorPage">
    <div style="background-color: floralwhite; width: 600px; height: auto; position: relative; top: 163px; margin: auto;">
        <div style="padding-top: 32px; padding-bottom: 32px; color: red">
            ${requestScope.message}
        </div>
    </div>
</body>
</html>
