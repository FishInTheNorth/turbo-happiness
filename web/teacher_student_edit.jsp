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
                        <a class="mdc-drawer-link" href="teacher_pt_list.jsp">
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
                    <span>修改学生信息</span>
                </div>
                <form action="#" method="post">
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper1">
                                <div id="tf-box-example1" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box1" class="mdc-text-field__input"name="name" aria-controls="name-validation-message">
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
                                    <input required pattern=".{1,}" type="text" id="tf-box3" class="mdc-text-field__input"name="major" aria-controls="name-validation-message">
                                    <label for="tf-box3" class="mdc-text-field__label">专业</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg3">
                                    专业不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper2">
                                <div id="tf-box-example2" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box2" class="mdc-text-field__input" name="phone" aria-controls="name-validation-message">
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
                                    <input type="text" id="tf-box-leading" class="mdc-text-field__input" name="qq">
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
                                <input class="mdc-radio__native-control" type="radio" id="ex0-default-radio1"  checked name="sex">
                                <div class="mdc-radio__background">
                                    <div class="mdc-radio__outer-circle"></div>
                                    <div class="mdc-radio__inner-circle"></div>
                                </div>
                            </div>
                            <label id="ex0-default-radio1-label" for="ex0-default-radio1">男</label>
                        </div>
                        <div class="mdc-form-field">
                            <div class="mdc-radio" data-mdc-auto-init="MDCRipple">
                                <input class="mdc-radio__native-control" type="radio" id="ex0-default-radio2" name="sex">
                                <div class="mdc-radio__background">
                                    <div class="mdc-radio__outer-circle"></div>
                                    <div class="mdc-radio__inner-circle"></div>
                                </div>
                            </div>
                            <label id="ex0-default-radio2-label" for="ex0-default-radio2">女</label>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper4">
                                <div id="tf-box-example4" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box4" class="mdc-text-field__input" name="company" aria-controls="name-validation-message">
                                    <label for="tf-box4" class="mdc-text-field__label">实习单位</label>
                                    <div class="mdc-text-field__bottom-line"></div>
                                </div>
                                <p class="mdc-text-field-helper-text mdc-text-field-helper-text--validation-msg" id="name-validation-msg4">
                                    实习单位不能为空
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop"
                         style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo" STYLE="float: left">
                            <select class="mdc-multi-select" id="selProv" name="province" onchange="changeProv()" style="height: 40px">
                                <option value="">请选择所在省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="北京市">北京市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="天津市">天津市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="上海市">上海市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="重庆市">重庆市</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="河北省">河北省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="山西省">山西省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="辽宁省">辽宁省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="吉林省">吉林省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="黑龙江省">黑龙江省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="江苏省">江苏省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="浙江省">浙江省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="安徽省">安徽省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="福建省">福建省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="江西省">江西省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="山东省">山东省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="河南省">河南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="湖北省">湖北省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="湖南省">湖南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="广东省">广东省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="海南省">海南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="四川省">四川省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="贵州省">贵州省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="云南省">云南省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="陕西省">陕西省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="甘肃省">甘肃省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="青海省">青海省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="台湾省">台湾省</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="内蒙古自治区">内蒙古自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="广西壮族自治区">广西壮族自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="西藏自治区">西藏自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="宁夏回族自治区">宁夏回族自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="新疆维吾尔自治区">新疆维吾尔自治区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="香港特别行政区">香港特别行政区</option>
                                <option class="mdc-list-item" role="option" tabindex="0" value="澳门特别行政区">澳门特别行政区</option>
                            </select>
                        </div>
                        <div class="template-demo" id="city" STYLE="float:left;visibility: hidden">
                            <select  class="mdc-multi-select"id="selCity" name="city" style="height: 40px">

                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <br>
                    <div class="mdc-layout-grid__cell mdc-layout-grid__cell--span-4-desktop" style="margin: 30px 240px 0px 240px;">
                        <div class="template-demo">
                            <div id="demo-tf-box-wrapper7">
                                <div id="tf-box-example7" class="mdc-text-field mdc-text-field--box w-100">
                                    <input required pattern=".{1,}" type="text" id="tf-box7" class="mdc-text-field__input" name="contacts" aria-controls="name-validation-message">
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
                                    <input required pattern=".{1,}" type="text" id="tf-box8" class="mdc-text-field__input" name="contactsPhone" aria-controls="name-validation-message">
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
