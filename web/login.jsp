<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/21
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <%@include file="verityIsLogin.jsp" %>
    <%@include file="header.jsp" %>

    <div class="container">
        <div class="login-form" style="width: 300px; margin: auto;">

            <div style="padding: 10px 20px 10px;">
                <div class="page-header">
                    <h1>登录页面
                        <small>老炮儿</small>
                    </h1>
                </div>
                <p class="text-danger" style="font-size: 12px">${msg}</p>
                <form class="bs-example bs-example-form" action="UserServlet" method="post" role="form">
                    <input type="hidden" value="login" name="action" />
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">账&nbsp;&nbsp;户</span>
                        <input type="text" name="name" class="form-control" placeholder="请输入用户名...">
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">密&nbsp;&nbsp;码</span>
                        <input type="password" name="password" class="form-control" placeholder="请输入密码...">
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">验&nbsp;&nbsp;证</span>
                        <input type="text" name="verityCode" class="form-control" placeholder="请输入验证码...">
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <img alt="" src="CodeServlet" id="verityImg" class="verity" title="点击图片刷新"></div>
                    <br>
                    <div class="input-group input-group-sm" style="width: 100%">
                        <div style="float: left; width: 50%">
                        <label>记住我&nbsp;&nbsp;</label>
                        <label>
                            <input type="checkbox" name="remember" />
                        </label></div>
                        <div style="float: right;">
                            <a >忘记密码&nbsp;&nbsp;</a>
                        </div>

                    </div><br>
                    <input class="btn-xs" type="submit" value="登录">
                    <input class="btn-xs" type="reset" value="重置">
                </form>

            </div>
        </div>
    </div>
    <%@include file="footer.jsp"%>


</body>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript">
    $("#verityImg").click(function (){
        this.src = "CodeServlet?" + new Date();
    })
</script>
</html>
