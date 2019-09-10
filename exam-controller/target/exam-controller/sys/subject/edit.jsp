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

		<title>编辑试题功能</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/theme.css">
		<script src="<%=basePath%>js/jquery.js" type="text/javascript"></script>
		<script src="layer/layer.js"></script>
	</head>

	<body class="content1">
		<script>
    		$('#a_leader_txt', parent.document).html('试题编辑功能管理');
		</script>
		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/savesubject" id="tf">

					<div class="well">
						<div class="tab-pane active in">
							<label>
								题干：
							</label>
							<input type="hidden" name="sid" value="${item.sid}" />
							<input type="text" name="scontent" value="${item.scontent}"
							maxlength="100"/>
							<label>
								A选项内容：
							</label>
							<input type="text" name="sa" maxlength="100"
								value="${item.sa}">
							<label>
								B选项内容：
							</label>
							<input type="text" name="sb" maxlength="100"
								value="${item.sb}">
							<label>
								C选项内容：
							</label>
							<input type="text" name="sc" maxlength="100"
								value="${item.sc}">
							<label>
								D选项内容：
							</label>
							<input type="text" name="sd" maxlength="100"
								value="${item.sd}">
							<label>
								标准选项：
							</label>
							<input type="text" name="skey" maxlength="100"
								value="${item.skey}">
							<label>
								试题状态：
							</label>
							<select name="sstate">
								<c:choose>
									<c:when test="${item.sstate==\"1\"}">
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
					</div>
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-info" value="保存 " onclick="save();">
						<input type="button" class="btn " value="取消 "onclick="closelayer();">
					</div>
				</form>
			</div>
		</div>
	<script>
		function save(){
			var form = new FormData(document.getElementById("tf"));
			$.ajax({
				type:"post",
				url:"savesubject",
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
	</body>
</html>
