<%--
  Created by IntelliJ IDEA.
  User: fausto
  Date: 2021/6/12
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=basePath%>"/>
</head>
<body>

    <center>
        <div style="font-size: xxx-large ; color: aqua">
            <table>
                <tr>
                   <td>学生id:</td>
                   <td>${student.id}</td>
                </tr>
                <tr>
                    <td>学生姓名:</td>
                    <td>${student.name}</td>
                </tr>
                <tr>
                    <td>学生年龄:</td>
                    <td>${student.age}</td>
                </tr>
            </table>
        </div>
    </center>

</body>
</html>
