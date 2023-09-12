<%--
  Created by IntelliJ IDEA.
  User: Amentcity
  Date: 2023/6/5
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>/WEB-INF/jsp/hello.jsp从request作用域获取数据</h3>
    <h3>name数据:${param.name}</h3><br>
    <h3>age数据:${param.age}</h3>
    <h3>去参数数据:<%=request.getParameter("name")%></h3>
</body>
</html>
