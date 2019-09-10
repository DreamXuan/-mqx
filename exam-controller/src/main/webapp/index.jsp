<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML>
<html>
<head >

    <base target="main" />
    <title>欢迎使用在线考试管理系统</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="layer/layer.js"></script>
</head>

<body style="background-color:#f2f9fd;">
    <div class="header bg-main">
        <div class="logo margin-big-left fadein-top">
            <h1><img src="css/images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />后台管理中心</h1>
        </div>
        <div class="navbar-nav navbar-right">
            <a href="javascript:void(0);" class="button button-little bg-blue"><span class="icon-user"></span> ${user.usertruename}</a> &nbsp;&nbsp;
            <a class="button button-little bg-red" href="#" target="_self" onclick="Exit()"><span class="icon-power-off"></span> 退出登录</a>
        </div>
        <div class=" navbar-nav navbar-right">
            <a href="javascript:void(0);" class="button button-little bg-blue"><span class="time"><em id="time"></em></span></a> &nbsp;&nbsp;
        </div>
    </div>
    <div class="leftnav">
        <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
        <c:forEach items="${list}" var="top">
            <c:if test="${top.funpid==\"-1\"}">
                <h2><span class="icon-briefcase"></span>${top.funname}</h2>
                <ul id="error-menu${top.funid}" class="nav nav-list collapse" style="display:block">
                    <c:forEach items="${list}" var="child">
                        <c:if test="${child.funpid==top.funid}">
                            <li>
                                <a href="${child.funurl}" target="right"><span class="icon-caret-right"></span>${child.funname}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
            </c:if>
        </c:forEach>
    </div>

    <ul class="bread">
        <li><a href="javascript:void(0);" target="right" class="icon-home"> 首页</a></li>
        <li><a href="javascript:void(0);" target="right" id="a_leader_txt">网站信息</a></li>
    </ul>

    <div class="admin">
        <iframe scrolling="auto" rameborder="0" name="right" width="100%" height="100%"></iframe>
    </div>

</body>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
    function Exit() {
        layer.confirm('确认要退出吗？',{
            btn: ['是', '否'],//按钮
            icon: 3,
        }, function (index) {
            $.ajax({
                url: "/logout",
                type: "post",
                dataType: "json",
                success: function (result) {
                    if (200 == result.status) {
                        $(window).attr('location', 'login.jsp');
                    }
                },
                error: function () {
                    $(window).attr('location', 'index.jsp');
                }
            });
        });
    }

    function currentTime() {
        var d = new Date(), str = '';
        str += d.getFullYear() + '年';
        str += d.getMonth() + 1 + '月';
        str += d.getDate() + '日';
        str += d.getHours() + '时';
        str += d.getMinutes() + '分';
        str += d.getSeconds() + '秒';
        return str;
    }

    setInterval(function () {
        $('#time').html(currentTime)
    }, 1000);
</script>
</html>