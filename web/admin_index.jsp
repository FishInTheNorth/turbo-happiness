<%--
  Created by IntelliJ IDEA.
  User: zk182
  Date: 2018/12/27
  Time: 9:30
  To change this template use File | Settings | File Templates.
  用于管理员个人信息查询
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="util.*, bean.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${empty sessionScope.userName}">
    <c:redirect url="login.jsp?f=5" />
</c:if>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>管理员界面</title>
    <link rel="stylesheet" href="css/style1.css">
    <link rel="shortcut icon" href="images/favicon.png"/>
</head>
<script type="text/javascript">
    function showTime() {
        nowtime = new Date();
        year = nowtime.getFullYear();
        month = nowtime.getMonth() + 1;
        date = nowtime.getDate();
        document.getElementById("mytime").innerText = year + "年" + month + "月" + date + " " + nowtime.toLocaleTimeString();
    }

    setInterval("showTime()", 1000);
</script>
<body>
<div class="body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
        <!--导航栏-->
        <nav class="mdc-persistent-drawer__drawer">
            <!--顶上图标-->
            <div class="mdc-persistent-drawer__toolbar-spacer">
                <strong>管理员界面</strong>
            </div>
            <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/adminInfo">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            个人信息查询
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/adminEdit">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">track_changes</i>
                            个人信息修改
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="admin_changePassword.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">event</i>
                            修改密码
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="admin_register_pt.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">dashboard</i>
                            添加实训
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/adminTeacherList">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">grid_on</i>
                            查询教师信息
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/adminTrainLsit">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">pages</i>
                            查询学生未提交情况
                        </a>
                    </div>
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/adminCount">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">pie_chart_outlined</i>
                            统计实训信息
                        </a>
                    </div>
                    <!--下侧按钮-->
                    <div class="mdc-list-item mdc-drawer-item purchase-link">
                        <a href="logout.jsp"
                           class="mdc-button mdc-button--raised mdc-button--dense mdc-drawer-link"
                           data-mdc-auto-init="MDCRipple">
                            登出系统
                        </a>
                    </div>
                </nav>
            </div>
        </nav>
    </aside>
    <!-- partial -->
    <!-- partial:partials/_navbar.html -->
    <header class="mdc-toolbar mdc-elevation--z4 mdc-toolbar--fixed">
        <div class="mdc-toolbar__row">
            <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
                <a href="#" class="menu-toggler material-icons mdc-toolbar__menu-icon">menu</a>
                <span class="mdc-toolbar__input">
            <!--查询框div class="mdc-text-field">
              <input type="text" class="mdc-text-field__input" id="css-only-text-field-box"
                     placeholder="Search anything...">
            </div-->
                    <!--学校log-->
                    <div class="mdc-text-field">
                <a href="http://www.nchu.edu.cn/" class="brand-logo">
                    <img src="images/schoolLog.png" alt="logo" style="height: 50px">
                </a>
                    </div>
          </span>
            </section>
            <!--用户信息及当前时间-->
            <section class="mdc-toolbar__section mdc-toolbar__section--align-end" role="toolbar">
                <font size="3x" face="KaiTi" style="color: white">欢迎你，${ sessionScope.userName} &nbsp&nbsp&nbsp<span
                        id="mytime"></span></font>
            </section>
        </div>
    </header>
    <div class="page-wrapper mdc-toolbar-fixed-adjust">
        <main class="content-wrapper">
            <div style="background:url(images/bg.png) ;background-size:120% 100%;-moz-background-size:100% 100%;
margin: 30px 30px 15px 30px;height: 400px">
                <ul class="mdc-list-group" style="float: left;margin: 30px 0px 30px 80px">
                    <li class="mdc-list-item"><label id="UserTypeNoName">工号：</label><span id="Account">${bean.adminId} </span></li>
                    <li class="mdc-list-item"><label>姓名：</label><span>${bean. adminName}</span></li>
                    <li class="mdc-list-item"><label>性别：</label><span>${bean.sex==1?'男':'女'}</span></li>
                    <li class="mdc-list-item"><label>QQ：</label><span>${bean.adminQq}</span></li>
                    <li class="mdc-list-item"><label>联系电话：</label><span>${bean.adminPhone}</span></li>
                </ul>
                <div style="float: right;margin: 30px 120px 30px 80px"><img src="images/ima.png" width="95.6px" height="113.9px">
                    <br>
                    <a href=" #themes/free-material-admin-template/" target="_blank"
                       class="mdc-button mdc-button--raised mdc-button--dense mdc-drawer-link"
                       data-mdc-auto-init="MDCRipple">
                        上传头像
                    </a>
                </div>
            </div>
        </main>
    </div>
</div>
<script src="node_modules/material-components-web/dist/material-components-web.min.js"></script>
<script src="node_modules/jquery/dist/jquery.min.js"></script>
<script src="node_modules/chart.js/dist/Chart.min.js"></script>
<script src="node_modules/progressbar.js/dist/progressbar.min.js"></script>
<script src="js/misc.js"></script>
<script src="js/text_Field.js"></script>
<script src="js/dashboard.js"></script>
</body>

</html>
