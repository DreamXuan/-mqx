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

		<title>编辑角色管理</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
		<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
		<script src="layer/layer.js"></script>
	</head>

	<body class="content1">
		<script>
    		$('#a_leader_txt', parent.document).html('编辑角色管理');
		</script>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/saverole" id="tf">

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="roleid" value="${item.roleid}"/>
							<label>
								角色名称：
							</label>
							<input type="text" name="rolename" maxlength="10"
								value="${item.rolename}">
							<label>
							
								角色状态：
							</label>
							<select name="rolestate">
								<c:choose>
									<c:when test="${item.rolestate==\"1\"}">
									<option value="1" selected="selected">正常</option>
									<option value="0">锁定</option>		
									</c:when>
									<c:otherwise>
									<option value="1">正常</option>
									<option value="0" selected="selected">锁定</option>	
									</c:otherwise>
								</c:choose>
								
							</select>
							<label>
								角色介绍：
							</label>
								<%--<input type="text" name="roledesc" maxlength="100"
								value="${item.roledesc}">--%>
							<div class="col-sm-9">
							       <textarea name="roledesc" class="form-control" id="form_textarea" placeholder=""
									  onkeyup="checkLength(this);">${item.roledesc }</textarea>
								<span class="wordage">剩余字数：<span id="sy" style="color:Red;">200</span>字</span>
							</div>
							<div style="color: red">
								${msg}
							</div>
						</div>
					</div>
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-info" value="保存 " onclick="save();">
						<input type="button" class="btn" value="取消 "onclick="closelayer();">
					</div>
				</form>
			</div>
		</div>
		<script>
			function save(){
				var form = new FormData(document.getElementById("tf"));
				$.ajax({
					type:"post",
					url:"saverole",
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
			/*字数限制*/
			function checkLength(which) {
				var maxChars = 200; //
				if (which.value.length > maxChars) {
					layer.open({
						icon: 2,
						title: '提示框',
						content: '您出入的字数超多限制!',
					});
					// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
					which.value = which.value.substring(0, maxChars);
					return false;
				} else {
					var curr = maxChars - which.value.length; //250 减去 当前输入的
					document.getElementById("sy").innerHTML = curr.toString();
					return true;
				}
			};
		</script>
	</body>
</html>