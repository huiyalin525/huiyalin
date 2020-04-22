<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/28
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--请求参数绑定
    <a href="/param/testparam?username=user&password=123">请求参数绑定</a>
    把数据封装到Account类中
    <form action="/param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        金额：<input type="text" name="money"/><br/>
        用户姓名：<input type="text" name="user.uname"/><br/>
        用户年龄：<input type="text" name="user.name"/><br/>
        <input type="submit" value="提交">
    </form> --%>
    <%--把数据封装在Account类中，类中存在list 和 map集合
    <form action="/param/saveAccount" method="post">
        姓名：<input type="text" name="username"/><br/>
        密码：<input type="text" name="password"/><br/>
        金额：<input type="text" name="money"/><br/>
        用户姓名：<input type="text" name="users[0].uname"/><br/>
        用户年龄：<input type="text" name="users[0].name"/><br/>
        用户姓名：<input type="text" name="map['0'].uname"/><br/>
        用户年龄：<input type="text" name="map['0'].name"/><br/>
        <input type="submit" value="提交">
    </form>--%>
    <%--自定义类型转换--%>
    <%--<form action="/param/saveUser" method="post">

        用户姓名：<input type="text" name="uname"/><br/>
        用户年龄：<input type="text" name="name"/><br/>
        用户生日：<input type="text" name="date"/><br/>
        <input type="submit" value="提交">
    </form>--%>
    <a href="/param/testServlet">请求参数绑定</a>
 </body>
</html>
