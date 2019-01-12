
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<c:if test="${empty sessionScope.userName}">
    <c:redirect url="login.jsp?f=5" />
</c:if>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>修改个人信息</title>
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
            window.location.href = 'studentEditServlet';
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
                <strong>学生界面</strong>
            </div>
         <div class="mdc-list-group">
                <nav class="mdc-list mdc-drawer-menu">
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="studentInfo">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">desktop_mac</i>
                            个人信息查询
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="student_edit.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">track_changes</i>
                            个人信息修改
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="student_changePassword.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">event</i>
                            修改密码
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="student_registerInformation.jsp">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">dashboard</i>
                            登记实训信息
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="studentSubmit">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">grid_on</i>
                            提交报告
                        </a>
                    </div>
                    <!--侧栏选项-->
                    <div class="mdc-list-item mdc-drawer-item">
                        <a class="mdc-drawer-link" href="studentGrade">
                            <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
                               aria-hidden="true">pages</i>
                            查询成绩
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
                <font size="3x" face="KaiTi" style="color: white">欢迎你，${sessionScope.userName}&nbsp&nbsp&nbsp<span
                        id="mytime"></span></font>
            </section>
        </div>
    </header>
    <div class="page-wrapper mdc-toolbar-fixed-adjust">
        <main class="content-wrapper">
            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop">
                <div style="text-align: center;height: 40px;font-size:30px;letter-spacing:8px;line-height:60px">
                    <span>修改个人信息</span>
                </div>
                <form action="studentEditServlet" method="post">
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper2">
                                <div id="tf-box-example2" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box2" class="mdc-text-field__input" 
                                    name="studentPhone" aria-controls="name-validation-message">
                                    <label for="tf-box2" class="mdc-text-field__label">手机号</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg2">
                                    手机号不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-leading-wrapper">
                                <div id="tf-box-leading-example" class="mdc-text-field mdc-text-field--box w-100">
                                    <input type="text" id="tf-box-leading" class="mdc-text-field__input" 
                                    name="qq">
                                    <label for="tf-box-leading" class="mdc-text-field__label">QQ</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper4">
                                <div id="tf-box-example4" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box4" class="mdc-text-field__input" 
                                    name="company" aria-controls="name-validation-message">
                                    <label for="tf-box4" class="mdc-text-field__label">实习单位</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg4">
                                    实习单位不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper5">
                                <div id="tf-box-example5" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box5" class="mdc-text-field__input" 
                                    name="province" aria-controls="name-validation-message">
                                    <label for="tf-box5" class="mdc-text-field__label">所在省</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg5">
                                    所在省不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper6">
                                <div id="tf-box-example6" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box6" class="mdc-text-field__input" 
                                    name="city" aria-controls="name-validation-message">
                                    <label for="tf-box6" class="mdc-text-field__label">所在市</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg6">
                                    所在市不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper7">
                                <div id="tf-box-example7" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box7" class="mdc-text-field__input" 
                                    name="contacts" aria-controls="name-validation-message">
                                    <label for="tf-box7" class="mdc-text-field__label">单位联系人</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg7">
                                    单位联系人不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper8">
                                <div id="tf-box-example8" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box8" class="mdc-text-field__input" 
                                    name="contactsPhone" aria-controls="name-validation-message">
                                    <label for="tf-box8" class="mdc-text-field__label">联系人电话</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg8">
                                    联系人电话不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <!--下侧按钮-->
                    <div class="mdc-list-item mdc-drawer-item purchase-link" >
                        <button class="mdc-button mdc-button--raised" data-mdc-auto-init="MDCRipple" style="margin: 0 auto" 
                        onclick="sub()">
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
