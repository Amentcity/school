<%--
  Created by IntelliJ IDEA.
  User: Amentcity
  Date: 2023/6/6
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    退出系统，送session中删除数据
    <%
      session.removeAttribute("name");
    %>
</body>
</html>
