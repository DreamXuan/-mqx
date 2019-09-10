<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML>
<html>

<head>
	<base href="">
	<meta charset="utf-8">
	<title>在线答题</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/paper.css">
	<link rel="stylesheet" href="css/pintuer.css">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/bootstrap.js"></script>
	<script src="layer/layer.js"></script>
</head>

<body>
	<nav class="navbar navbar-default" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#" class="btn btn-xs btn-info">在线考试系统</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/paperlist">试题列表</a></li>
				<li><a href="/errorpaperlist">查看错题</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${user.userid!=null}">
						<li>
							<a>
								${user.usertruename},您好
							</a>
						</li>
						<li id="tuichu" onclick="Exit()"><a href="#" ><i class="iconfont"></i>退出</a>
						</li>
					</c:when>
					<c:otherwise>
						<li><a href="login.jsp">登录</a></li>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>

	<main class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h3 class="panel-title">查看试题</h3>
			</div>
			<div class="panel-body">
				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>
									试题名称
								</th>
								<th>
                                    题目数量
								</th>

								<th style="width: 90px;">
									&nbsp;&nbsp;&nbsp;&nbsp;操作
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="paper">
								<tr>
									<td>
										${paper.pname}
									</td>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${paper.scount}
									</td>

									<td>

										<a href="paperdetail?pname=${paper.pname}" class="btn btn-xs btn-info">开始答题</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>

</body>
<script type="text/javascript">

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
			//重置表单
			function resetThirdOrder(){
				$(".form-inline")[0].reset();
				$(".input-xlarge").attr("value","");
			}

</script>

</html>