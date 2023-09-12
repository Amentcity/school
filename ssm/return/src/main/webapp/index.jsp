<%--
  Created by IntelliJ IDEA.
  User: Amentcity
  Date: 2023/6/1
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.7.0.js"></script>

</head>
<body>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString.do" method="post">
        姓名:<label><input type="text" name="name"></label><br>
        年龄:<label><input type="text" name="age"></label><br>
        <input type="submit" value="提交参数">
    </form>
    <p>处理器方法返回String表示视图名称</p>
    <form action="returnString2.do" method="post">
        姓名:<label><input type="text" name="name"></label><br>
        年龄:<label><input type="text" name="age"></label><br>
        <input type="submit" value="提交参数">
    </form>
    <br>
    <button id="btn">发起Ajax请求</button>
</body> <script type="text/javascript">
    $(function (){
        $("button").click(function (){
            $.ajax({
                // url:"returnStudentJsonArray.do",
                url:"returnStringData.do",
                data:{
                    name:"张三",
                    age:20
                },
                type:"post",
                dataType:"text",
                success:function (resp){
                    //resp从服务器端返回的是json格式的字符串
                    //jquery会把字符串转换成json对象赋值给resp形参。
                    //[{"name":"李四","age":20},{"name":"张三","age":20}]
                    //alert(resp.name+"     "+resp.age);
                    // $.each(resp,function (i,n){
                    //     alert(n.name+"  "+n.age)
                    // })
                    alert("返回的文本数据："+resp);
                }
            })
        })
    })
</script>
</html>
