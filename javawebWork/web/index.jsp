<%--
  Created by IntelliJ IDEA.
  User: YJL
  Date: 2021/4/7
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>
<%--    1、导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
<%--    2、jQuery导入--%>
    <script src="js/jquery-2.1.0.min.js"></script>
<%--    3、导入bootstrap的js文件--%>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
  </head>
  <body>
  <div>
    ${user.username},欢迎您
  </div>
  <div align="center" style="">
      <a href="${pageContext.request.contentType}/FindCarsServlet" style="font-size: 33px;text-decoration: none">
          腾飞汽车租赁公司
      </a>
  </div>
  </body>
</html>
