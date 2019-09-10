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

		<title>试题功能列表</title>
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
					action="/subjectlist">
					<input class="input-xlarge" placeholder="试题名称..." name="scontent"
						type="text" style="height: 33px" value="${param.scontent}">
					<button class="btn icon-search">查询</button>
					<button class="btn icon-refresh" type="reset" onclick="resetThirdOrder()">重置</button>
					<a class="btn  btn-info"
						href="<%=basePath%>sys/subject/add.jsp"> <i
						class="icon-plus"></i> 新增试题</a>
				</form>

				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>
									题号
								</th>
								<th>
									题干
								</th>
								<th>
									A选项内容
								</th>
								<th>
									B选项内容
								</th>
								<th>
									C选项内容
								</th>
								<th>
									D选项内容
								</th>
								<th>
									正确选项
								</th>
								<th>
									题目状态
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
										${item.sid}
									</td>
									<td>
										${item.scontent}
									</td>
									<td>
										${item.sa}
									</td>
									<td>
										${item.sb}
									</td>
									<td>
										${item.sc}
									</td>
									<td>
										${item.sd}
									</td>
									<td>
										${item.skey}
									</td>
									<td>
										<c:choose>
											<c:when test="${item.sstate==\"1\"}">
												正常
											</c:when>
											<c:otherwise>锁定</c:otherwise>
										</c:choose>
									</td>
									<td>
										<a  onclick="edit('${item.sid}')" href="javascript:;"  class=" btn-xs btn-info" >修改</a>
										<a href="javascript:;"  onclick="del(this,'${item.sid}')" class=" btn-xs btn-info">删除</a>
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
									<a href="/subjectlist?pageNo=${pageInfo.pageNum-1}">上一页</a>
								</c:if>
							</li>
							<li class="active"><a>${pageInfo.pageNum }</a></li>
							<li>
								<c:if test="${pageInfo.pageNum+1>pageInfo.pages}" var="fp">
									<a style="disabled:true">下一页</a>
								</c:if>
								<%--<c:forEach items="${pageInfo.list}" var="item">--%>
								<c:if test="${!fp}">
									<a href="/subjectlist?pageNo=${pageInfo.pageNum+1}">下一页</a>
								</c:if>
								<%--</c:forEach>--%>

							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	<script type="text/javascript">
		/*修改*/
		function edit(id){
			layer.open({
				type: 2,
				// time: 1000,
				title:'修改题目',
				area: ['500px','500px'],
				shadeClose: false,
				content: 'editsubject?sid='+id,
				end: function () {
						location.reload();

				},

			});
		}
		/*删除*/
		function del(obj,id){
			layer.confirm('确认要删除吗？',function(index){
				$.ajax({
					type:"post",
					url:"delsubject?sid="+id,
					dataType:"json",
					success: function(data){
						//alert(data)
						if(data != null){
							$(obj).parents("tr").remove();
							layer.msg('已删除!',{icon:1,time:1000});
						}
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
	</body>
</html>
