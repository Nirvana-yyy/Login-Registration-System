<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YJL
  Date: 2021/4/8
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>租车</title>
    <%--    1、导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%--    2、jQuery导入--%>
    <script src="js/jquery-2.1.0.min.js"></script>
    <%--    3、导入bootstrap的js文件--%>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<form action="${pageContext.request.contentType}/FindACarServlet" method="post">
<div>
    <table class="table table-hover table-bordered">
    <tr class="success">
        <th><input type="radio" id="radio"></th>
        <th>编号</th>
        <th>类型</th>
        <th>品牌</th>
        <th>型号</th>
        <th>租价</th>
        <th>座位数</th>
        <th>车牌号</th>
    </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
            <tr>
                <th><input type="radio" name="uid" value="${user.id}"></th>
                <td>${user.id}</td>
                <td>${user.type}</td>
                <td>${user.brand}</td>
                <td>${user.model}</td>
                <td>${user.perRent}</td>
                <td>${user.seat}</td>
                <td>${user.number}</td>
<%--                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contentType}/FindACarServlet?id=${user.id}">租赁此车</a> </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container" style="width: 40%;text-align: center">
    <input type="text" name="days" id="days"  placeholder="租赁天数">
</div>

<div class="form-group" style="text-align: center;">
    <input class="btn btn btn-primary" type="submit" value="提交">
</div>
</form>
</body>


</html>
