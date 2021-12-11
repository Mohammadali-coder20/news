<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/13/2021
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save News</title>
    <script type="application/javascript" src="/js/main.js"></script>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body>
<div class="content">
    <form method="post" action="/save/news.do" enctype="multipart/form-data">
        <input name="id" value="${requestScope.news.id}" hidden/>
        <fieldset>
            <c:choose>
                <c:when test="${mode eq 'edit'}">
                    <legend>Edit News</legend>
                </c:when>
                <c:otherwise>
                    <legend>Save News</legend>
                </c:otherwise>
            </c:choose>
            <div>
                <div><label>subject</label></div>
                <input type="text" name="subject" placeholder="Enter the subject in English" value="${requestScope.news.subject}"/><br/>
                <div><label>title</label></div>
                <input type="text" name="title" style="direction: rtl" value="${requestScope.news.title}"/><br/><br/>
                <div><label>body</label></div>
                <textarea name="body" style="direction: rtl; width: 639px; height: 180px;">${requestScope.news.body}</textarea><br/><br/>
                <div><label>file</label></div>
                <c:choose>
                    <c:when test="${mode eq 'edit'}">
                        <img src="data:image/jpg;base64,${requestScope.news.base64Image}" width="400" height="250"/><br/> <br/>
                        <div>do you want to upload new image</div>
                        <br/>
                        <input type="button" value="click here" onclick="uploadNewImage()" id="button">
                    </c:when>
                    <c:otherwise>
                        <input type="file" name="img" style="position: relative; left: 83px; top: 15px;"/><br/>
                    </c:otherwise>
                </c:choose>
                <input type="file" name="img" id="uploadImg" hidden/><br/>
            </div>
            <br/>
            <input type="text" name="id" value="${requestScope.id}" style="visibility: hidden" />
            <c:choose>
                <c:when test="${mode eq 'edit'}">
                    <input type="submit" value="Edit" style="position: relative; right: 93px;"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Save" style="position: relative; right: 93px"/>
                </c:otherwise>
            </c:choose><br/><br/>
            <c:choose>
                <c:when test="${sessionScope.user.admin}">
                    <a href="/admin/Panel.do"><input type="button" value="Back to panel"/></a>
                </c:when>
                <c:otherwise>
                    <a href="/user/Panel.do"><input type="button" value="Back to panel"/></a>
                </c:otherwise>
            </c:choose>
        </fieldset>
    </form>

</div>
</body>
</html>

