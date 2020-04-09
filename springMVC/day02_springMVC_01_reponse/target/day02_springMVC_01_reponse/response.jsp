<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/3/1
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="lib/js/jQuery-3.4.1.js"></script>
    <script type="text/javascript">
        //页面时间
        $(function () {
           $("#btn").click(function () {
               $.ajax({
                   //编写json格式设置属性和值
                   url:"user/textAjax",
                   contentType:"application/json;charset=UTF-8",
                   dataType:"json",
                   data:'{"name":"nihao","password":"123","age":"30"}',
                   type:"post",
                   success:function(data){
                    //data服务器端响应的json的数据进行解析
                       alert(data);
                       alert(data.name);
                       alert(data.password);
                       alert(data.age);
                   }
                   })
           })
        });

    </script>
</head>
<body>
<%--测试普通的响应--%>
<%--<a href="user/testString">testString</a>
<a href="user/testVoid">testVoid</a>--%>

<%--测试ModelAndView--%>
<%--<a href="user/testModelAndView">testModelAndView</a>--%>

  <button id="btn">发送ajax的请求</button>
</body>
</html>
