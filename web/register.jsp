<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/21
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<style>
    label {
        font-size: 12px;
    }
</style>
<body>

    <%@include file="header.jsp" %>

    <div class="container">
        <div class="register-form" style="width: 300px; margin: auto;">
            <div style="padding: 10px 20px 10px;">
                <div class="page-header">
                    <h1>注册页面
                        <small>老炮儿</small>
                    </h1>
                </div>
                <form class="bs-example bs-example-form" action="UserServlet" method="post" role="form" enctype="multipart/form-data">
                    <input type="hidden" value="register" name="action" />
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">账&nbsp;&nbsp;户</span>
                        <input type="text" name="name" class="form-control" id="name" placeholder="请输入用户名..." required>
                    </div>
                    <span id="is_name" style="font-size: 12px;"></span>
                    <br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">密&nbsp;&nbsp;码</span>
                        <input type="password" name="password" class="form-control" placeholder="请输入密码..." required>
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">邮&nbsp;&nbsp;箱</span>
                        <input type="email" name="email" class="form-control" placeholder="请输入邮箱..." required>
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <span class="input-group-addon">头&nbsp;&nbsp;像</span>
                        <input type="file" name="avatar" class="form-control">
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <label>
                            <input type="radio" value="男" name="sex" checked="checked" />
                        </label>男
                        <label>
                            <input type="radio" value="女" name="sex" />
                        </label>女
                        <label>
                            <input type="radio" value="不明" name="sex" />
                        </label>不明
                    </div>
                    <br>
                    <div class="input-group input-group-sm">
                        <label for="province">
                            <select name="provinceId" id="province">
                        </select>&nbsp;&nbsp;省&nbsp;&nbsp;
                        </label>
                        <label for="city">
                            <select name="cityId" id="city">
                        </select>&nbsp;&nbsp;市</label>
                    </div>
                    <br>
                    <input class="btn-xs" type="submit" value="注册">
                    <input class="btn-xs" type="reset" value="重置" >
                </form>
            </div>
        </div>
    </div>
    <%@include file="footer.jsp"%>


</body>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="static/base/js/verification.js"></script>
<script type="text/javascript" src="static/base/js/province-city.js"></script>
</html>
