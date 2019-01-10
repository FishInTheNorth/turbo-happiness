<%--
  Created by IntelliJ IDEA.
  User: zk182
  Date: 2018/12/29
  Time: 23:03
  To change this template use File | Settings | File Templates.
  用于管理员注册实训
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${empty sessionScope.userName}">
    <c:redirect url="login.jsp?f=5"/>
</c:if>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>注册实训界面</title>
    <link rel="stylesheet" href="css/style1.css">
    <link rel="shortcut icon" href="images/favicon.png"/>
</head>

<body>
<script src="node_modules/jquery/dist/jquery.min.js"></script>
<script type="text/javascript">
    function showTime() {
        nowtime = new Date();
        year = nowtime.getFullYear();
        month = nowtime.getMonth() + 1;
        date = nowtime.getDate();
        document.getElementById("mytime").innerText = year + "年" + month + "月" + date + " " + nowtime.toLocaleTimeString();
    }
    setInterval("showTime()", 1000);
    $(document).ready(function () {
        $("#shixi").click(function () {
            $("#shixibut").trigger("click");
        });
        $("#shixun").click(function () {
            $("#shixunbut").trigger("click");
        });
        $("#shijian").click(function () {
            $("#shijianbut").trigger("click");
        });
        $("#xueshen").click(function () {
            $("#xueshenbut").trigger("click");
        });
    });

</script>
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
            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop">
                <div style="text-align: center;height: 40px;font-size:30px;letter-spacing:8px;line-height:60px">
                    <span>注册实训信息</span>
                </div>
                <form action="/adminAddTrain" method="post" id="addTrain" enctype="multipart/form-data">
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper">
                                <div id="tf-box-leading-example" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="text" id="tf-box-leading" class="mdc-text-field__input"
                                           placeholder="如：2018-1019学年"
                                           name="schoolYear">
                                    <label for="tf-box-leading" class="mdc-text-field__label">学年</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <input type="file" style="display:none" id="shixibut"
                                   accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                            <button type="button" class="mdc-button mdc-button--stroked secondary-stroked-button"
                                    id="shixi">
                                导入实习教师信息
                            </button>
                            <font color="#999999">选择excel表，内有实习老师工号</font>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper1">
                                <div id="tf-box-leading-example1" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="date" id="tf-box-leading1" class="mdc-text-field__input"
                                           name="shixiBeginTime">
                                    <label for="tf-box-leading1" class="mdc-text-field__label">实习开始时间</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper2">
                                <div id="tf-box-leading-example2" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="date" id="tf-box-leading2" class="mdc-text-field__input"
                                           name="shixiEndTime">
                                    <label for="tf-box-leading2" class="mdc-text-field__label">实习结束时间</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <input type="file" style="display:none" id="shixunbut"
                                   accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                            <button type="button" class="mdc-button mdc-button--stroked secondary-stroked-button"
                                    id="shixun">
                                导入实训教师信息
                            </button>
                            <font color="#999999">选择excel表，内有实训老师工号</font>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper3">
                                <div id="tf-box-leading-example3" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="date" id="tf-box-leading3" class="mdc-text-field__input"
                                           name="shixunBeginTime">
                                    <label for="tf-box-leading3" class="mdc-text-field__label">实训开始时间</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper4">
                                <div id="tf-box-leading-example4" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="date" id="tf-box-leading4" class="mdc-text-field__input"
                                           name="schoolYear">
                                    <label for="tf-box-leading4" class="mdc-text-field__label">实训结束时间</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <input type="file" style="display:none" id="shijianbut"
                                   accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                            <button type="button" class="mdc-button mdc-button--stroked secondary-stroked-button"
                                    id="shijian">
                                导入实践教师信息
                            </button>
                            <font color="#999999">选择excel表，内有实践老师工号</font>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper5">
                                <div id="tf-box-leading-example5" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="date" id="tf-box-leading5" class="mdc-text-field__input"
                                           name="shijianBeginTime">
                                    <label for="tf-box-leading5" class="mdc-text-field__label">实践开始时间</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper6">
                                <div id="tf-box-leading-example6" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="date" id="tf-box-leading6" class="mdc-text-field__input"
                                           name="shijianEndTime">
                                    <label for="tf-box-leading6" class="mdc-text-field__label">实践结束时间</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <input type="file" style="display:none" id="xueshenbut"
                                   accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                            <button type="button" class="mdc-button mdc-button--stroked secondary-stroked-button"
                                    id="xueshen">
                                导入学生信息
                            </button>
                            <font color="#999999">选择excel表，内有学生学号</font>
                        </div>
                    </div>
                    <br>
                    <!--下侧按钮-->
                    <div class="mdc-list-item mdc-drawer-item purchase-link">
                        <button type="submit" class="mdc-button mdc-button--raised" data-mdc-auto-init="MDCRipple"
                                style="margin: 0 auto" id="addTrainbut">
                            确认
                        </button>
                    </div>
                </form>
            </div>
        </main>
    </div>
</div>
<script src="node_modules/material-components-web/dist/material-components-web.min.js"></script>
<script src="node_modules/chart.js/dist/Chart.min.js"></script>
<script src="node_modules/progressbar.js/dist/progressbar.min.js"></script>
<script src="js/misc.js"></script>
<script src="js/text_Field.js"></script>
<script src="js/dashboard.js"></script>
</body>

</html>

