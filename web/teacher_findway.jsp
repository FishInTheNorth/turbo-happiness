<%--
  Created by IntelliJ IDEA.
  User: zk
  Date: 2019/1/6
  Time: 17:29
  To change this template use File | Settings | File Templates.
  用于教师查看实训回访路径
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${empty sessionScope.userName}">
    <c:redirect url="login.jsp?f=5" />
</c:if>
<head>
    <title>查看回访路径界面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<script type="text/javascript">
    function sub(){
        document.getElementById("form1").submit();
    }
</script>
<body>
<div class="body-wrapper">
    <aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
        <!--导航栏-->
        <nav class="mdc-persistent-drawer__drawer">
            <!--顶上图标-->
            <div class="mdc-persistent-drawer__toolbar-spacer">
                <strong>教师界面</strong>
            </div>
            <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacherInfo">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            个人信息查询
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/teacherEdit">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">track_changes</i>
                            个人信息修改
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacher_changePassword.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">event</i>
                            修改密码
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacherPtList">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">dashboard</i>
                            查询学生信息
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacherFindway">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">grid_on</i>
                            回访路径
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacherMarking">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">pages</i>
                            批阅汇报
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
                <font size="3x" face="KaiTi" style="color: white">欢迎你，${ sessionScope.userName}&nbsp&nbsp&nbsp<span
                        id="mytime"></span></font>
            </section>
        </div>
    </header>
    <div class="page-wrapper mdc-toolbar-fixed-adjust">
        <main class="content-wrapper">
            <div class="mdc-card">
                <form action="teacherFindway" method="post" id="form1">
                    <section class="mdc-card__supporting-text">
                        <div class="mdc-layout-grid__inner" style="margin: 0 auto">
                            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-2-desktop">
                                <div class="template-demo">
                                    <div id="demo-tf-box-leading-wrapper">
                                        <div id="tf-box-leading-example" class="mdc-text-field mdc-text-field--box w-100" >
                                            <input type="text" id="tf-box-leading" class="mdc-text-field__input" name="trainNumber" value="<c:if test="${trainNumber != null}">${trainNumber}</c:if>">
                                            <label for="tf-box-leading" class="mdc-text-field__label">实训编号</label>
                                            <div class="mdc-text-field__bottom-line"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-2-desktop">
                                <div class="template-demo">
                                    <div id="demo-tf-box-leading-wrapper1">
                                        <div id="tf-box-leading-example1" class="mdc-text-field mdc-text-field--box w-100" >
                                            <input type="date" id="tf-box-leading1" class="mdc-text-field__input" name="beginTime" value="<c:if test="${beginTime != null}">${beginTime}</c:if>">
                                            <label for="tf-box-leading1" class="mdc-text-field__label">开始时间</label>
                                            <div class="mdc-text-field__bottom-line"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-2-desktop">
                                <div class="template-demo">
                                    <div id="demo-tf-box-leading-wrapper4">
                                        <div id="tf-box-leading-example4" class="mdc-text-field mdc-text-field--box w-100" >
                                            <input type="date" id="tf-box-leading4" class="mdc-text-field__input" name="endTime" value="<c:if test="${endTime != null}">${endTime}</c:if>">
                                            <label for="tf-box-leading4" class="mdc-text-field__label">结束时间</label>
                                            <div class="mdc-text-field__bottom-line"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-3-desktop">
                                <div class="template-demo">
                                    <select class="mdc-list mdc-simple-menu__items" name = "stage" id = "stage" style="height: 58px" onchange="sub()">
                                        <option value = "">所在阶段</option>
                                        <option class="mdc-list-item" role="option" tabindex="0" value="实习阶段" <c:if test="${stage == '实习阶段'}">${"selected"}</c:if>>实习阶段</option>
                                        <option class="mdc-list-item" role="option" tabindex="0" value="实训阶段" <c:if test="${stage == '实训阶段'}">${"selected"}</c:if>>实训阶段</option>
                                        <option class="mdc-list-item" role="option" tabindex="0" value="实践阶段" <c:if test="${stage == '实践阶段'}">${"selected"}</c:if>>实践阶段</option>

                                    </select>
                                </div>
                            </div>
                            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-2-desktop">
                                <br>
                                <button  type="submit" name = "sert" class="mdc-button mdc-button--raised mdc-button--compact mdc-ripple-upgraded" >
                                    查询
                                </button></div>
                        </div>
                    </section>
                </form>
            </div>
            <br>
            <div class="mdc-layout-grid__cell stretch-card mdc-layout-grid__cell--span-12">
                <div class="mdc-card table-responsive">
                    <div class="table-heading px-2 px-1 border-bottom">
                        <h1 class="mdc-card__title mdc-card__title--large">实训表</h1>
                    </div>
                    <table class="table table-hoverable">
                        <thead>
                        <tr>
                            <th class="text-left">实训编号</th>
                            <th>阶段</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${data }"	var="bean">
                            <tr>
                                <td class="text-left">${bean.trainId}</td>
                                <td>${bean.stage}</td>
                                <td>${bean.beginTime}</td>
                                <td>${bean.endTime}</td>
                                <td>
                                    <a class="mdc-button mdc-button--stroked" href="teacher_ptWay.jsp">
                                        查看回访路径
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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

<script type="text/javascript">

</script>
</body>

</html>
