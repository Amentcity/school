<%--
  Created by IntelliJ IDEA.
  User: Amentcity
  Date: 2023/6/4
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <title>查询学生Ajax</title>
    <base href="<%=basePath%>">
  <script type="text/javascript" src="js/jquery-3.7.0.js"></script>
  <script type="text/javascript">
      $(function (){
        //当前页面dom加载后，执行loadStudentData()
        loadStudentData();
        $("#btnLoader").click(function (){
          loadStudentData();
        })
      })
      function loadStudentData(){
        $.ajax({
          url:"student/queryStudent.do",
          type:"get",
          dataType:"json",
          success:function (data){
            //清楚旧的数据
            $("#info").html("");
            //增加新的数据
            $.each(data,function (i,n){
              $("#info").append("<tr>").append("<td>"+n.id+"</td>").append("<td>"+n.id+"</td>").append("<td>"+n.name+"</td>").append("<td>"+n.age+"</td>").append("</tr>")
            })
          }
        })
      }
  </script>
</head>
<body>
  <div align="center">
    <table>
      <thead>
        <tr>
          <td>学号</td>
          <td>姓名</td>
          <td>年龄</td>
        </tr>
      </thead>
      <tbody id="info">

      </tbody>
    </table>
    <input type="button" id="btnLoader" value="查询数据"/>
  </div>
</body>
</html>
