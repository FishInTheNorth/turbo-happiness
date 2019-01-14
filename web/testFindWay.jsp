<%--
  Created by IntelliJ IDEA.
  User: zk182
  Date: 2018/12/30
  Time: 13:51
  To change this template use File | Settings | File Templates.
  用于修改所带实训的学生信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${empty sessionScope.userName}">
    <c:redirect url="login.jsp?f=5" />
</c:if>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>修改教师信息</title>
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

    function changeProv() {
        var prov = $('#selProv').val();
        $.ajax({
            url: 'ProvinceCityServlet',
            data: {'prov': prov},
            method: 'post',
            success: function (data) {
                $('#selCity').empty();
                $('#selCity').append('<option value="">请选择所在市</option>');
                for (var i = 0; i < data.length; i++) {
                    $('#selCity').append('<option value="' + data[i].city + '">' + data[i].city + '</option>');
                }
                $('#city').css("visibility", "visible");
            },
            error: function (err) {
                console.log(err);
            }
        });
    }

</script>
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
            <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop">
                <div style="text-align: center;height: 40px;font-size:30px;letter-spacing:8px;line-height:60px">
                    <span>生成访回路径</span>
                </div>
                <hr>
                <form action="teacherFindWay" method="post">

                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 50px 350px 20px 350px;">
                        <div class="template-demo" STYLE="float: left">
                            <select class="mdc-multi-select" id="selProv" name="province" onchange="changeProv()" style="height: 40px">
                                <option value="">请选择起始地</option> <!-- value="${param.s7}" -->
                                <option class="mdc-list-item" role="option" tabindex="0" value="北京市" <c:if test="${param.s7=='北京市'}">${"selected" }</c:if>>北京市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="天津市" <c:if test="${param.s7=='天津市'}">${"selected" }</c:if>>天津市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="上海市" <c:if test="${param.s7=='上海市'}">${"selected" }</c:if>>上海市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="重庆市" <c:if test="${param.s7=='重庆市'}">${"selected" }</c:if>>重庆市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="河北省" <c:if test="${param.s7=='河北省'}">${"selected" }</c:if>>河北省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="山西省" <c:if test="${param.s7=='山西省'}">${"selected" }</c:if>>山西省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="辽宁省" <c:if test="${param.s7=='辽宁省'}">${"selected" }</c:if>>辽宁省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="吉林省" <c:if test="${param.s7=='吉林省'}">${"selected" }</c:if>>吉林省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="黑龙江省" <c:if test="${param.s7=='黑龙江省'}">${"selected" }</c:if>>黑龙江省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="江苏省" <c:if test="${param.s7=='江苏省'}">${"selected" }</c:if>>江苏省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="浙江省" <c:if test="${param.s7=='浙江省'}">${"selected" }</c:if>>浙江省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="安徽省" <c:if test="${param.s7=='安徽省'}">${"selected" }</c:if>>安徽省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="福建省" <c:if test="${param.s7=='福建省'}">${"selected" }</c:if>>福建省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="江西省" <c:if test="${param.s7=='江西省'}">${"selected" }</c:if>>江西省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="山东省" <c:if test="${param.s7=='山东省'}">${"selected" }</c:if>>山东省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="河南省" <c:if test="${param.s7=='河南省'}">${"selected" }</c:if>>河南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="湖北省" <c:if test="${param.s7=='湖北省'}">${"selected" }</c:if>>湖北省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="湖南省" <c:if test="${param.s7=='湖南省'}">${"selected" }</c:if>>湖南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="广东省" <c:if test="${param.s7=='广东省'}">${"selected" }</c:if>>广东省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="海南省" <c:if test="${param.s7=='海南省'}">${"selected" }</c:if>>海南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="四川省" <c:if test="${param.s7=='四川省'}">${"selected" }</c:if>>四川省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="贵州省" <c:if test="${param.s7=='贵州省'}">${"selected" }</c:if>>贵州省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="云南省" <c:if test="${param.s7=='云南省'}">${"selected" }</c:if>>云南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="陕西省" <c:if test="${param.s7=='陕西省'}">${"selected" }</c:if>>陕西省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="甘肃省" <c:if test="${param.s7=='甘肃省'}">${"selected" }</c:if>>甘肃省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="青海省" <c:if test="${param.s7=='青海省'}">${"selected" }</c:if>>青海省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="内蒙古自治区" <c:if test="${param.s7=='内蒙古自治区'}">${"selected" }</c:if>>内蒙古自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="广西壮族自治区" <c:if test="${param.s7=='广西壮族自治区'}">${"selected" }</c:if>>广西壮族自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="西藏自治区" <c:if test="${param.s7=='西藏自治区'}">${"selected" }</c:if>>西藏自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="宁夏回族自治区" <c:if test="${param.s7=='宁夏回族自治区'}">${"selected" }</c:if>>宁夏回族自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="新疆维吾尔自治区" <c:if test="${param.s7=='新疆维吾尔自治区'}">${"selected" }</c:if>>新疆维吾尔自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="香港特别行政区" <c:if test="${param.s7=='香港特别行政区'}">${"selected" }</c:if>>香港特别行政区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="澳门特别行政区" <c:if test="${param.s7=='澳门特别行政区'}">${"selected" }</c:if>>澳门特别行政区</option>
                            </select>
                        </div>
                        <div class="template-demo" id="city" STYLE="float:left;visibility: hidden">
                            <select  class="mdc-multi-select"id="selCity" name="city" style="height: 40px" onchange="this" >
                                <option class="mdc-list-item" role="option" tabindex="0" value="${param.s12}" <c:if test="${param.s12!=null}">${"selected" }</c:if>>${param.s12}</option>
                            </select>
                        </div>
                    </div>
                    <br>

                    <!--下侧按钮-->
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 50px 240px 20px 240px;">
                       <div class="mdc-list-item mdc-drawer-item purchase-link" >
                        <input type="hidden" value="${param.trainId}" name="trainId">
                        <button class="mdc-button mdc-button--raised" data-mdc-auto-init="MDCRipple" style="margin: 0 auto" onclick="sub()">
                            开始
                        </button>
                       </div>
                    </div>
                    <hr>
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