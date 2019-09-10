<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>试卷管理</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/theme.css">
		<link rel="stylesheet" href="css/pintuer.css">
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/bootstrap.js"></script>
		<script src="layer/layer.js"></script>
	</head>

	<body class="content1">
		<div class="container-fluid">
			<div class="row-fluid">
				<form class="form-inline" method="post"
					action="/sys/paperlist">
					<input class="input-xlarge" placeholder="试卷名称..." name="pname"
						type="text" maxlength="10" style="height: 33px" value="${param.pname}">
					<button class="btn icon-search">查询</button>
					<button class="btn icon-refresh" type="reset" onclick="resetThirdOrder()">重置</button>
					<a class="btn  btn-info"
						href="sys/paper/add.jsp"> <i
							class="icon-plus"></i> 新增试卷 </a>
				</form>

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
							<c:forEach items="${pageInfo.list}" var="item">
								<tr>
									<td>
										${item.pname}
									</td>
									<td>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${item.scount}
									</td>

									<td>
										<a href="/sys/paperdetail?pname=${item.pname}"class="btn btn-xs btn-info">查看试题</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<ul class="pagination pagination-right">
							<li>
								<a>共计：${pageInfo.pages}页 / ${pageInfo.total}条记录</a>
							</li>
							<li>
								<c:if test="${pageInfo.pageNum-1<1}" var="fp">
									<a style="disabled:true">上一页</a>
								</c:if>
								<c:if test="${!fp}">
									<a href="/sys/paperlist?pageNo=${pageInfo.pageNum-1}">上一页</a>
								</c:if>
							</li>
							<li class="active"><a>${pageInfo.pageNum }</a></li>
							<li>
								<c:if test="${pageInfo.pageNum+1>pageInfo.pages}" var="fp">
									<a style="disabled:true">下一页</a>
								</c:if>
								<%--<c:forEach items="${pageInfo.list}" var="item">--%>
								<c:if test="${!fp}">
									<a href="/sys/paperlist?pageNo=${pageInfo.pageNum+1}">下一页</a>
								</c:if>
								<%--</c:forEach>--%>

							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		//重置表单
		function resetThirdOrder(){
			$(".form-inline")[0].reset();
			$(".input-xlarge").attr("value","");
		}
	</script>
	</body>
</html>
