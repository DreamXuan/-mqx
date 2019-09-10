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

		<title>编辑用户</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
		<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
	</head>

	<body class="content1">
		<script>
    		$('#a_leader_txt', parent.document).html('编辑用户');
		</script>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/saveuser" id="tf">

					<div class="well">
						<div class="tab-pane active in">
							<label>
								用户名：
							</label>
							<input type="hidden" name="userid" value="${item.userid}" />
							
							<input type="text" name="username" value="${item.username}"
								readonly="readonly">
							<label>
								角色类型：
							</label>
							<select name="roleid">
								<option value="0">
									${item.roleid}
								</option>
								<option value="1">
									学生
								</option>
								<option value="-1">
									超级管理员
								</option>
								<option value="2">
									试题管理员
								</option>
							</select>
							<label>
								用户密码：
							</label>
							<input type="text" name="userpwd" maxlength="10"
								value="${item.userpwd}">
							<label>
								用户真实名字：
							</label>
							<input type="text" name="usertruename" value="${item.usertruename}"
								maxlength="100">
							<label>
								用户状态：
							</label>
							<select name="userstate">
								<c:choose>
									<c:when test="${item.userstate==\"1\"}">
									<option value="1" selected="selected">正常</option>
									<option value="0">锁定</option>		
									</c:when>
									<c:otherwise>
									<option value="1">正常</option>
									<option value="0" selected="selected">锁定</option>	
									</c:otherwise>
								</c:choose>
								
							</select>
							<div style="color: red">
								${msg}
							</div>
						</div>
						<div class="btn-toolbar">
							<input type="submit" class="btn btn-info" value="保存 " onclick="save();">
							<input type="button" class="btn " value="取消 "onclick="closelayer();">
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
	<script>
		function save(){
			var form = new FormData(document.getElementById("tf"));
			$.ajax({
				type:"post",
				url:"saveuser",
				dataType:"json",
				async:false,
				data :form,
				processData:false,
				contentType:false,
				success: function(d) {
					if (d.status = 200) {
						alert("修改成功")
						// 获得frame索引
						var index = parent.layer.getFrameIndex(window.name);

						//关闭当前frame
						parent.layer.close(index);

					}else {
						alert(d.data)
					}
				}
			});
		}
		function closelayer(){
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
	</script>
</html>
