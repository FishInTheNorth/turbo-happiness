<%--
  Created by IntelliJ IDEA.
  User: zk182
  Date: 2018/12/29
  Time: 22:52
  To change this template use File | Settings | File Templates.
  用于教师修改个人信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>修改教师信息界面</title>
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
    function sub() {
        if (confirm('确定修改信息?')) {
            window.location.href = '#';
            this.form.submit();
        }
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
                <strong>教师界面</strong>
            </div>
            <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="/teacherInfo">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            个人信息查询
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacherEdit">
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
                        <a class="mdc-drawer-link" href="teacher_findway.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">grid_on</i>
                            回访路径
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="teacher_Marking.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">pages</i>
                            批阅汇报
                        </a>
                    </div>
                    <!--下侧按钮-->
                    <div class="mdc-list-item mdc-drawer-item purchase-link">
                        <a href="login.jsp"
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
                <font size="3x" face="KaiTi" style="color: white">欢迎你，${ sessionScope.userName}教师&nbsp&nbsp&nbsp<span
                        id="mytime"></span></font>
            </section>
        </div>
    </header>
    <div class="page-wrapper mdc-toolbar-fixed-adjust">
        <main class="content-wrapper">
            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop">
                <div style="text-align: center;height: 40px;font-size:30px;letter-spacing:8px;line-height:50px">
                    <span>修改个人信息</span>
                </div>
                <form action="teacherEditDo" method="post">
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper1">
                                <div id="tf-box-example1" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box1" class="mdc-text-field__input"
                                           name="adminName" aria-controls="name-validation-message" value="<c:if test="${bean.teacherName != null}">${bean.teacherName}</c:if>">
                                    <label for="tf-box1" class="mdc-text-field__label">姓名</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg1">
                                    姓名不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper3">
                                <div id="tf-box-example3" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box2" class="mdc-text-field__input"
                                           name="adminName" aria-controls="name-validation-message" value="<c:if test="${bean.teacherPhone != null}">${bean.teacherPhone}</c:if>">
                                    <label for="tf-box1" class="mdc-text-field__label">联系电话</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg3">
                                    联系电话不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper2">
                                <div id="tf-box-example2" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box3" class="mdc-text-field__input"
                                           name="adminPhone" aria-controls="name-validation-message" value="<c:if test="${bean.getMajor1() != null}">${bean.getMajor1()}</c:if>">
                                    <label for="tf-box2" class="mdc-text-field__label">专业</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg2">
                                    专业不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper">
                                <div id="tf-box-leading-example" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="text" id="tf-box-leading" class="mdc-text-field__input" name="qq" value="<c:if test="${bean.teacherQq != null}">${bean.teacherQq}</c:if>">
                                    <label for="tf-box-leading" class="mdc-text-field__label">QQ</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="mdc-form-field">
                            <p>&nbsp&nbsp&nbsp性别：</p>
                            <div class="mdc-radio" data-mdc-auto-init="MDCRipple">
                                <input class="mdc-radio__native-control" type="radio" id="ex0-default-radio1" name="sex"  value="1" <c:if test="${bean.getSex1() == 1}">${"checked" }</c:if>>
                                <div class="mdc-radio__background">
                                    <div class="mdc-radio__outer-circle"></div>
                                    <div class="mdc-radio__inner-circle"></div>
                                </div>
                            </div>
                            <label id="ex0-default-radio1-label" for="ex0-default-radio1" >男</label>
                        </div>
                        <div class="mdc-form-field">
                            <div class="mdc-radio" data-mdc-auto-init="MDCRipple">
                                <input class="mdc-radio__native-control" type="radio" id="ex0-default-radio2" name="sex"  value="0" <c:if test="${bean.getSex1() == 0}">${"checked" }</c:if>>
                                <div class="mdc-radio__background">
                                    <div class="mdc-radio__outer-circle"></div>
                                    <div class="mdc-radio__inner-circle"></div>
                                </div>
                            </div>
                            <label id="ex0-default-radio2-label" for="ex0-default-radio2">女</label>
                        </div>
                    </div>
                    <!--下侧按钮-->
                    <div class="mdc-list-item mdc-drawer-item purchase-link" >
                        <button class="mdc-button mdc-button--raised" data-mdc-auto-init="MDCRipple" style="margin: 0 auto" onclick="sub()">
                            修改
                        </button>
                    </div>
                </form>

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

