<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/17/2021
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>show full news</title>
    <script type="application/javascript" src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
    <div class="content">
        <div>
            <div style="float: left; position: relative; left: 20px; top: 20px;">
                <img src="data:image/jpg;base64,${requestScope.news.base64Image}" width="500px" height="250px"/>
            </div>
            <div style="direction: rtl; float: left; width: 448px; position: relative; left: 26px; top: 20px; text-align: right;">
                <div>موضوع</div><br/>
                <div>${requestScope.news.subject}</div><br/>
                <div>عنوان</div><br/>
                <div>${requestScope.news.title}</div><br/>
            </div>
            <div style="clear: left; width: 960px; text-align: right; margin: auto; position: relative; top: 40px">
                <div>متن خبر</div>
                <div>${requestScope.news.body}</div>
            </div>
            <div style="width: 566px; height: auto; margin: auto; position: relative; top:99px; direction: rtl;">
                <c:if test="${sessionScope.user.admin}">
                    <a href="/edit-news.do?id=${news.id}"><img src="/img/48763_file_edit_icon.png" width="20px" height="20px"/></a>
                    <a href="/delete-news.do?id=${news.id}"><img src="/img/48762_remove_delete_delete file_icon.png" width="20px" height="20px"/></a>
                </c:if>
            </div>
            <a href="/user/load-news.do"><input type="button" value="back to news list" style="border-radius: 10px; position: relative; top: 101px;"/></a>
        </div><br/><br/><br/><br/><br/><br/>
    </div>
</body>
</html>
