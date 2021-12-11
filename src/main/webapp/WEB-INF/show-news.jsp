<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/14/2021
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
    <link rel="stylesheet" href="/css/main.css"/>
    <script type="application/javascript" src="/js/main.js"></script>
</head>
<body>
<c:forEach items="${newsList}" var="news" varStatus="loop">
    <div class="content">

        <div style="height: 300px; margin: auto;">
            <div style="float: left; position: relative; top: 24px; left: 15px;">
                <img src="data:image/jpg;base64,${news.base64Image}" width="400" height="250"/>
            </div>
            <div style=" width:566px; height: 250px; text-align: center; float: left; direction: rtl; position: relative; top: 24px; left: 15px;">
                <div>
                    موضوع :${news.subject}
                </div><br/>
                <div style="float: right; width: 559px; text-align: right; text-overflow: ellipsis; overflow: hidden;white-space: nowrap;">
                    عنوان : ${news.title}
                </div>
                <div style="float: right; text-align: right;position: relative; top: 12px;">متن خبر :</div>
                <div style="float: none; text-overflow: ellipsis; overflow: hidden; width: 559px; height: 148px; text-align: right;">
                    <br/>${news.body}
                </div>
                <div style="width: 566px; height: auto; margin: auto; position: absolute; top:244px;">
                    <c:choose>
                        <c:when test="${sessionScope.user.admin}">
                            <a href="/edit-news.do?id=${news.id}"><img src="/img/48763_file_edit_icon.png" width="20px" height="20px"/></a>
                            <a href="/delete-news.do?id=${news.id}"><img src="/img/48762_remove_delete_delete file_icon.png" width="20px" height="20px"/></a>
                            <a href="/show-full-news.do?id=${news.id}"><img src="/img/465070_article_blog_content_news_note_icon.png" width="20px" height="20px"/></a>
                        </c:when>
                        <c:otherwise>
                            <a href="/show-full-news.do?id=${news.id}" onclick="loadViewedNews(${news.id})"><img src="/img/465070_article_blog_content_news_note_icon.png" width="20px" height="20px"/></a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div style="width: 566px; height: auto; margin: auto; position: relative; top: 25px;right: 292px; direction: rtl;">
                <img src="/img/115733_eye_see_show_watch_view_icon.png" width="18px" height="18px" style="margin-left: 95px;"/>
                <span id="${news.id}" style="position: absolute; left: 315px;">${applicationScope.map.get(requestScope.newsList.get(loop.index).id)}</span>
                <img src="/img/285670_calendar_icon.png" width="18px" height="18px"/>
                <span style="width: 102px; height: auto; font-size: 10px; position: absolute; top:254px;">${news.newsDate}</span>
            </div>
        </div>
    </div>
    <br/> <br/> <br/>
</c:forEach>
<c:choose>
    <c:when test="${sessionScope.user.admin}">
        <a href="/admin/Panel.do"><input type="button" value="Back to panel"/></a>
    </c:when>
    <c:otherwise>
        <a href="/user/Panel.do"><input type="button" value="Back to panel"/></a>
    </c:otherwise>
</c:choose>
<br/><br/><br/>
</body>
</html>
