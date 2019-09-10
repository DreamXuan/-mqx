<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>角色管理</title>
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
				<form class="form-inline" method="post" action="rolelist">
					<input class="input-xlarge" placeholder="角色名称..." name="rolename"
						type="text"style="height: 33px" value="${param.rolename}">
					<%--<input class="btn icon-search" type="submit" value="查询"/>--%>
					<button class="btn icon-search">查询</button>
					<button class="btn icon-refresh" type="reset" onclick="resetThirdOrder()">重置</button>
					<a class="btn  btn-info"
						href="<%=basePath%>sys/role/add.jsp"> <i
						class="icon-plus"></i> 新增角色 </a>
				</form>

				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>
									角色名称
								</th>
								<th>
									角色说明
								</th>
								<th>
									角色状态
								</th>
								<th style="width: 90px;">
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pageInfo.list}" var="item">
								<tr>
									<td>
										${item.rolename}
									</td>
									<td>
										${item.roledesc}
									</td>
									<td>&nbsp;&nbsp;&nbsp;
										<c:choose>
											<c:when test="${item.rolestate==\"1\"}">
												正常
											</c:when>
											<c:otherwise>锁定</c:otherwise>
										</c:choose>
									</td>
									<td>
										<c:if test="${item.roleid==-1 }">&nbsp;不能修改</c:if>
										<c:if test="${item.roleid!=-1 }">
											<a  onclick="edit_role('${item.roleid}')" href="javascript:;"  class=" btn-xs btn-info" >修改</a>
											<a  onclick="edit_right('${item.roleid}')" href="javascript:;"  class=" btn-xs btn-info" >权限</a>

										</c:if>

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
									<a href="/rolelist?pageNo=${pageInfo.pageNum-1}">上一页</a>
								</c:if>
							</li>
							<li class="active"><a>${pageInfo.pageNum }</a></li>
							<li>
								<c:if test="${pageInfo.pageNum+1>pageInfo.pages}" var="fp">
									<a style="disabled:true">下一页</a>
								</c:if>
								<%--<c:forEach items="${pageInfo.list}" var="item">--%>
								<c:if test="${!fp}">
									<a href="/rolelist?pageNo=${pageInfo.pageNum+1}">下一页</a>
								</c:if>
								<%--</c:forEach>--%>

							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	<script>
		/*修改角色*/
		function edit_role(id){
			layer.open({
				type: 2,
				// time: 1000,
				title:'修改角色',
				area: ['600px','500px'],
				shadeClose: false,
				content: 'editrole?roleid='+id,
				end: function () {
					location.reload();

				},

			});
		}

		/*修改权限*/
		function edit_right(id){
			layer.open({
				type: 2,
				// time: 1000,
				title:'修改权限',
				area: ['500px','400px'],
				shadeClose: false,
				content: 'editright?roleid='+id,
				end: function () {
					location.reload();

				},

			});
		}
		//重置表单
		function resetThirdOrder(){
			$(".form-inline")[0].reset();
			$(".input-xlarge").attr("value","");
		}
	</script>
	</body>
</html>
