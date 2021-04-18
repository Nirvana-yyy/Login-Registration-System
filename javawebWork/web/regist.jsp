<%--
  Created by IntelliJ IDEA.
  User: YJL
  Date: 2021/4/7
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>注册页面</title>
    <%--    1、导入css的全局样式--%>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <%--    2、jQuery导入--%>
    <script src="js/jquery-2.1.0.min.js"></script>
    <%--    3、导入bootstrap的js文件--%>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //点击更新验证码
        function refreshCode(){
            //获取验证码的图片对象
            var vcode = document.getElementById("vcode");
            vcode.src = "${pageContext.request.contentType}/checkCodeServlet?time="+new Date().getTime()
        }
        $(function () {
            //给username绑定失去焦点事件
            $("#username").blur(function () {
                //获取username文本输入框的值
                var username = $(this).val();
                //发送ajax请求
                $.get("FindUserServlet",{username:username},function (data) {
                    var span = $("#s_username");
                    //用户名存在
                    if (data.userExsit){
                        span.html(data.msg_regist);
                        span.css("color","green");
                    }else{
                        span.html(data.msg_regist);
                        span.css("color","red");
                    }
                })
            })
        })
    </script>

    <head>
        <title>新用户注册</title>
    </head>
<body>
<%-------------------表单------------------------------%>
<div class="container" style="width: 40%">
    <h3 style="text-align: center;">新用户注册</h3>
    <form action="${pageContext.request.contentType}/RegistServlet" method="post">
        <div class="form-group">

            <label for="username">用户名</label>
            <input type="text"  required="required" name="username" class="form-control" id="username" placeholder="请输入用户名">
            <%--        检验用户名是否存在--%>
            <span id="s_username"></span>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input required="required" type="password" name="password" class="form-control" id="password" placeholder="请输入密码">
        </div>
        <div class="form-inline">
            <label for="checkCode">验证码</label>
            <input type="text" required="required" name="checkCode" class="form-control" id="checkCode" style="width: 50%">
            <%--        点击图片更换验证码，路径待补全--%>
            <a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/checkCodeServlet" title="看不清请点击图片" id="vcode"/></a>
        </div>
        <div class="form-group" style="text-align: center;">
            <input type="submit" class="btn-info" value="注册">
        </div>

    </form>
    <%--    显示出错的提示框--%>
    <%--    响应消息待补全--%>
    <p class="text-danger"><strong>${msg}</strong></p>

</div>
</div>
<%--------------------------表单-----------------------------------------%>
</form>
</body>
</html>
