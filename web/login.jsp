<%--
  Created by IntelliJ IDEA.
  User: zk182
  Date: 2018/12/27
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <style>
        body {
            height: 100%;
            background: #0099FF;
            overflow: hidden;
        }

        canvas {
            z-index: -1;
            position: absolute;
        }
    </style>
    <script src="js/jquery.js"></script>
    <script src="js/verificationNumbers.js"></script>
    <script src="js/Particleground.js"></script>
    <script>
        $(document).ready(function() {
            //粒子背景特效
            $('body').particleground({
                dotColor : '#DDDDDD',
                lineColor : '#DDDDDD'
            });
        });
    </script>
</head>
<body>
<dl class="admin_login">
    <dt>
        <strong>专业实习实训管理系统</strong> <em>Professional Practice Training Management System</em>
    </dt>
    <form action="LoginServlet" method="post">
        <dd class="user_icon">
            <input type="text" placeholder="账号" name="account" class="login_txtbx" />
            <br>
        </dd>
        <dd class="pwd_icon">
            <input type="password" placeholder="密码" name="password"  class="login_txtbx" />
            <br>

        </dd>
        <dd class="val_icon">
            <select name="userType" class="login_txtbx">
                <option value="">用户类型</option>
                <option value="3">管理员</option>
                <option value="2">教师</option>
                <option value="1">学生</option>
            </select>
            <br>
        </dd>
        <!--dd class="val_icon">
            <div class="checkcode">
                <input type="text" id="J_codetext" placeholder="验证码" maxlength="4"
                    class="login_txtbx">
                <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas-->
        </div>
        <!--input type="button" value="验证码核验" class="ver_btn"/>
            onClick="validate();"-->
        </dd>
        <dd>
            <input type="submit" value="立即登陆" class="submit_btn" />
        </dd>
    </form>
    <dd>
        <p>© 2018-2019 版权所有</p>
        <font color="white">
        <c:if test="${param.f=='1'}">${"<font color='white'>用户名不能为空</font>"}</c:if>
        <c:if test="${param.f=='2'}">${"<font color='white'>密码不能为空</font>"}</c:if>
        <c:if test="${param.f=='3'}">${"<font color='white'>请选择一个类型</font>"}</c:if>
        <c:if test="${param.f=='4'}">${"<font color='white'>用户名或者密码不正确</font>"}</c:if>
        <c:if test="${param.f=='5'}">${"<font color='white'>会话过期</font>"}</c:if>
    </dd>
</dl>
</body>
</html>
