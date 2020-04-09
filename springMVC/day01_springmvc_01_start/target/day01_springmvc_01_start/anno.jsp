<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/29
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--常用的注解
    <a href="anno/testRequestParam?name=123">RequestParam</a>--%>
    <%--RequestBody请求体注解--%>
    <%--<form action="/anno/testRequestBody" method="post">

        用户姓名：<input type="text" name="uname"/><br/>
        用户年龄：<input type="text" name="name"/><br/>
        <input type="submit" value="提交">
    </form>--%>
    <%--测试传值--%>
<%--    <a href="/anno/testPathVariable/10">PathVariable</a>--%>
    <%--测试头部信息传值--%>
    <%--<a href="/anno/testRequestHeader">testRequestHeader</a>--%>
    <%--测试cookieValue获取cookie--%>
    <%--<a href="/anno/testCookieValue">testCookieValue</a>--%>
    <%--<form action="/anno/testModelAttribute" method="post">

        用户姓名：<input type="text" name="uname"/><br/>
        用户年龄：<input type="text" name="name"/><br/>
        <input type="submit" value="提交">
    </form>--%>
    <%--SessionAttributes注解--%>
    <a href="/anno/testSessionAttributes">testSessionAttributes</a>
    <a href="/anno/getSessionAttributes">getSessionAttributes</a>
    <a href="/anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
