<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/11/2021
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
    <link rel="stylesheet" href="/css/main.css"/>
</head>
<body id="loginPage">
    <div id="loginPanel" style="width: 328px; height: auto; border: blue solid 2px;background-color: snow; margin: 0 auto 0; position: relative; top: 228px;">
        <form action="/login.do">
            <div><label style="color: darkslategrey;font-weight: bold;">UserName</label></div>
            <div><input type="text" name="username" style="border: solid;"></div>
            <div><label style="color: darkslategrey; font-weight: bold;">Password</label></div>
            <div><input type="password" name="password" style="border: solid;"></div><br/>
            <input type="submit" value="Login"  style="border-radius: 11px; width: 66px; position: relative; left: 88px;float: left"/>
            <a href="/register.do"><input type="button" value="Register" style="border-radius: 10px; position: absolute; left: 173px;float: left;"/></a>
            <div style="width: 1px; height: 20px;"></div>
        </form>
    </div>





<%--     <div>--%>
<%--         <div style="border: red solid 2px; width: 200px; height: auto; text-align: center; margin: 0 auto 0; background-color: coral; margin-top: 88px;">--%>
<%--             <form style="color: darkslategrey" action="/login.do">--%>
<%--                <div style="font-weight: bold;">Username:</div><input type="text" name="username" style="border-radius: 4px 4px 4px 4px;"/><br/>--%>
<%--                <div style="font-weight: bold">Password:</div><input type="password" name="password" style="border-radius: 4px 4px 4px 4px;"/><br/>--%>
<%--&lt;%&ndash;                 <a href="/login.do"><div style="width: 54px; height: auto; background-color: crimson;border-radius: 8px; color: white; margin-left: 41px; margin-top: 5px; float: left;">login</div></a>&ndash;%&gt;--%>
<%--                 <input type="submit" value="login" style="width: 54px; height: auto; background-color: crimson;border-radius: 8px; color: white; margin-left: 41px; margin-top: 5px; float: left;"/>--%>
<%--                 <a href="/register.do"><div style="width: 54px; height: auto; background-color: crimson;border-radius: 8px; color: white; margin-left: 101px; margin-top: 5px; margin-bottom: -10px;">register</div></a>--%>
<%--             </form>--%>
<%--         </div>--%>
<%--     </div>--%>
</body>
</html>
