<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <link rel="stylesheet" type="text/css" href="css/pintuer.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <%--<link rel="stylesheet" type="text/css" href="css/regStyle.css">--%>
    <link rel="stylesheet" href="css/footer.css"/>
    <title>学生登录</title>
</head>

<body>
    <div class="bg"></div>
    <div class="container">
        <div class="line bouncein">
            <div class="xs6 xm4 xs3-move xm4-move">
                <div style="height:80px;"></div>
                <div class="media media-y margin-big-bottom">
                </div>
                <form action="/stulogin" method="post" class="login-form">
                    <div class="panel loginbox">
                        <div class="text-center margin-big padding-big-top">
                            <h1>在线考试系统</h1>
                            <div class="form-top-left">
                                <a data-type="student" href="javascript:void(0);" style="color: red;">学生登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;
                                <a data-type="admin" href="javascript:void(0);">管理员登录</a><br>
                                <br>
                                <p id="mes" style="color: red;">${msg}</p>
                            </div>
                        </div>
                        <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="text" class="input input-big" name="username" placeholder="登录账号" data-validate="required:请填写账号" />
                                    <span class="icon icon-user margin-small"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="field field-icon-right">
                                    <input type="password" class="input input-big" name="userpwd" placeholder="登录密码" data-validate="required:请填写密码" />
                                    <span class="icon icon-key margin-small"></span>
                                </div>
                            </div>
                        </div>

                        <div style="padding:30px;">
                            <button type="submit" class="button button-block bg-main text-big input-big">登录</button>
                            <div id="cont-bottom">
                                <div id="reg">
                                    <a href="register.jsp">没有账号？点此创建</a>
                                    &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a>忘记密码</a>
                                </div>
                                <div id="forget">

                                </div>
                        </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>
    </div>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/pintuer.js"></script>
    <script t>

		$('.form-top-left a').click(function () {
		    $('.form-top-left').children().removeAttr("style");
		    var type = $(this).css('color', 'red').attr("data-type");
		    if (type == 'student') {
		        $(document).attr("title", "学生登录");
		        $("#mes").html('');
		        /*$(".login-form").attr("action",  "user?cmd=stulogin");*/
		        $(".login-form").attr("action",  "/stulogin");
		    }else {
		        $(document).attr("title", "管理员登录");
		        $("#register").html('');
		        $("#mes").html('');
		        /*$(".login-form").attr("action", + "sys/user?cmd=login");*/
		        $(".login-form").attr("action",  "/adminlogin");
		    }
		})
	</script>
</body>

</html>