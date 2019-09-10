<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
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
    <title>在线答题</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/paper.css">
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
            <a class="navbar-brand" href="#">在线考试系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="paperlist">试题列表</a></li>
                <li class="active"><a href="/errorpaperlist">查看错题</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
					<c:when test="${user.userid!=null}">
						<li><a><c:out  value="${user.usertruename}"/>,您好</a></li>
						<li>
                        <li id="tuichu" onclick="Exit()"><a href="#"><i class="iconfont"></i>退出</a>
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
                <h3 class="panel-title">
                    <c:out value="${pname}"></c:out>
                </h3>
            </div>
            <div class="panel-body">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#Radio">错题库</a>
                        </h4>
                    </div>
                    <div id="Radio" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <ol>
                                <c:forEach items="${pageInfo.list}" var="item">
                                    <div class="subject" data-sid="${item.sid}" data-key="${item.skey}" data-skey="${item.studentkey}">
                                        <li> ${item.scontent}</li>
                                        <ol>
                                            <li><label data-value="A">${item.sa}</label></li>
                                            <li><label data-value="B">${item.sb}</label></li>
                                            <li><label data-value="C">${item.sc}</label></li>
                                            <li><label data-value="D">${item.sd}</label></li>
                                        </ol>
                                    </div>
                                </c:forEach>
                            </ol>

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
                                            <a href="/errorpaperdetail?pageNo=${pageInfo.pageNum-1}&spid=${pageInfo.list[0].spid}">上一页</a>
                                        </c:if>
                                    </li>
                                    <li class="active"><a>${pageInfo.pageNum }</a></li>
                                    <li>
                                        <c:if test="${pageInfo.pageNum+1>pageInfo.pages}" var="fp">
                                            <a style="disabled:true">下一页</a>
                                        </c:if>
                                        <%--<c:forEach items="${pageInfo.list}" var="item">--%>
                                            <c:if test="${!fp}">
                                                <a href="/errorpaperdetail?pageNo=${pageInfo.pageNum+1}&spid=${pageInfo.list[0].spid}">下一页</a>
                                            </c:if>
                                        <%--</c:forEach>--%>

                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </main>
    <script>
    // 获取basePath 
    var basePath = '<%=basePath%>'
    $(function(ev) {
        var len = $('.subject').length;
        $('.subject').each(function(index){
        var i = index
        var self = $(this)
        
        self.find('label').each(function(){
        	var label = $(this)
        	if(self.data('key')==label.data('value')){
        		label.parent().addClass('correct')
        	}
        	if(self.data('skey')==label.data('value')){
        		label.parent().addClass('error')
        	}
        })
        
        //var data = {userid:userid,sid:self.data('sid'),studentkey:self.data('skey'),studentstate:self.data('state'),pname:pname}
        })

    })
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
    </script>
</body>

</html>