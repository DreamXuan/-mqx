<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base href="<%=basePath%>">
    <title>注册页面</title>
    <!--引入Bootstrap-->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/iconfont/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="css/voingindex.css"/>
    <link rel="stylesheet" type="text/css" href="css/regStyle.css">
    <%--<link rel="stylesheet" href="css/footer.css"/>--%>
    <style>
        .iconfont{
            font-size: 22px;
        }
        .htmleaf-container{
            margin-top: -10px;
        }
    </style>
</head>

<body>

    <div class="wrapper">
        <div class="container">
            <h2>请开始你的注册</h2>

            <form class="form" onsubmit="return false" id="regForm">
                <input type="hidden" name="m" value="register">
                <span class="usernameSpan"></span>
                <input type="text" name="username" id="username" placeholder="用户名" onblur="ckUsername()">
                <span class="passwordSpan"></span>
                <input type="password" name="password" id="password" placeholder="密    码" onblur="ckPassword()">
                <span class="repasswordSpan"></span>
                <input type="password" name="repassword" id="repassword" placeholder="确认密码" onblur="ckRepassword()">
                <span class="telSpan"></span>
                <input type="text" name="tel" id="tel" placeholder="手机号" onblur="ckTel()">
                <span class="telCodeSpan"></span>
                <div id="code">
                    <input type="text" name="telCode" id="telCode" class="code" placeholder="验证码" onblur="ckTelCode()"><a href="#" onclick="getCode()" id="waitTime">获取验证码</a>

                </div>

                <button type="submit" id="register-button" onclick="registerFun()">注册</button>
            </form>
        </div>
        <div id="cont-bottom">
            <div id="bottomlog">
                <a href="login.jsp">登录</a>
            </div>
            <div id="bottomreturn">
                <a href="login.jsp">返回主页面</a>
            </div>
        </div>

        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

<!--分享功能-->
<!--<a class="bshareDiv" href="http://www.bshare.cn/share">分享按钮</a>
<script type="text/javascript" charset="utf-8" src="http://static.bshare.cn/b/buttonLite.js#uuid=&amp;style=3&amp;fs=4&amp;textcolor=#fff&amp;bgcolor=#9C3&amp;text=分享到">
</script>-->
<script src="static/js/jquery.min.js"></script>
<script src="static/bootstrap/js/bootstrap.min.js"></script>
<script src="static/js/userOper.js"></script>
<script>
    $(function(){
        var flag='<%=request.getAttribute("flag")%>';
    })
  function regShow(){
    event.preventDefault();
    $('form').fadeOut(500);
    $("h2").fadeOut(500);
    $("#cont-bottom").fadeOut(500)
    $("h1").css("display", "inherit");
    $("h1").fadeIn(1000);
    $('h1').addClass('form-success');
  };

  /**
   *  发送验证码
   */
  function getCode() {
      var i=60;
      var count = setInterval(function(){
          $("#code a").text("("+(i--)+"S)");
          $("#code a").removeAttr('onclick');
          if(i==0){
              $("#code a").text("获取验证码");
              $("#code a").attr('onclick',"getCode();");
              clearInterval(count)
          }
      }, 1000);
          var username = document.getElementById("username").value;
          var tel= document.getElementById("tel").value;
         /* window.location.href="/send?username="+str+"&tel="+number;*/
      $.ajax({
          method:'POST',
          url:'/send?username='+username+"&tel="+tel,
          async:false,
          dataType:'json',
          data:{
              tel:$("#tel").val(),
          },
          success:function (result) {
          }
      });
      $(function(){
          var flag='<%=request.getAttribute("flag")%>';
      })

  };
</script>

</body>
</html>
