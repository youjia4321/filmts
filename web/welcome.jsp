<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/21
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>欢迎界面</title>
</head>
<body>
    <%@include file="verityIsLogin.jsp" %>
    <%@include file="header.jsp" %>

    <div class="container">
        <div class="page-header">
            <h1>欢迎来到电影售票系统
                <small>老炮儿</small>
            </h1>
        </div>
        <div class="row clearfix">
            <div class="col-md-4 column">
                <h2>
                    Heading
                </h2>
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
                    tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
                    magna mollis euismod. Donec sed odio dui.
                </p>
                <p>
                    <a class="btn" href="#">View details »</a>
                </p>
            </div>
            <div class="col-md-4 column">
                <h2>
                    Heading
                </h2>
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
                    tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
                    magna mollis euismod. Donec sed odio dui.
                </p>
                <p>
                    <a class="btn" href="#">View details »</a>
                </p>
            </div>
            <div class="col-md-4 column">
                <h2>
                    Heading
                </h2>
                <p>
                    Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo,
                    tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
                    magna mollis euismod. Donec sed odio dui.
                </p>
                <p>
                    <a class="btn" href="#">View details »</a>
                </p>
            </div>
        </div>

    </div>

    <%@include file="footer.jsp"%>

</body>
<script type="text/html" id="loginDemo">
    <div style="padding: 20px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">
        <div class="layui-form-item" style="margin-bottom: 0">
            <div class="layui-inline">
                <label class="layui-form-label">验证账户</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">验证密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="password" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">图形验证</label>
                <div class="layui-input-inline">
                    <input type="text" id="verityCode" autocomplete="off" class="layui-input"><br>
                    <div class="input-group input-group-sm">
                        <img alt="" src="CodeServlet" class="verity" id="imgId">
                        <a class="btn" style="color: #fff" onclick="getCode()">刷新验证码</a>
                    </div>
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label" style="width: 100px">下次免密</label>
                <div class="layui-input-inline">
                    <input type="checkbox" id="remember" class="layui-form-checkbox">
                    </div>
                </div>
            </div>
        </div>
</script>
<script type="text/html" id="registerDemo">
    <div style="padding: 20px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">
        <div class="layui-form-item" style="margin-bottom: 0">
            <div class="layui-inline" >
                <label class="layui-form-label">账户名称</label>
                <div class="layui-input-inline">
                    <input type="text" id="rname" name="name" onblur="checkName(this)" required class="layui-input">
                </div>
            </div>
            <div class="layui-inline" >
                <label class="layui-form-label">账户密码</label>
                <div class="layui-input-inline">
                    <input type="password" id="rpassword" name="password" required autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline" >
                <label class="layui-form-label">账户邮箱</label>
                <div class="layui-input-inline">
                    <input type="email" id="remail" name="email" required autocomplete="off" class="layui-input">
                </div>
            </div>
<%--            <div class="layui-inline">--%>
<%--                <label class="layui-form-label">上传头像</label>--%>
<%--                <div class="layui-upload layui-input-inline">--%>
<%--                    <input type="file" id="userImage" name="userImage" class="layui-field-box" />--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="layui-inline">
                <label class="layui-form-label">选择性别</label>
                <div class="layui-input-inline" style="line-height: 38px">
                    <input type="radio" name="sex" value="男" checked="checked">男
                    <input type="radio" name="sex" value="女" >女
                    <input type="radio" name="sex" value="不明" >不明
                </div>
            </div>

            <div class="layui-inline">
                <label class="layui-form-label">选择地址</label>
                <div class="layui-input-inline" style="line-height: 38px;">
                    <select name="provinceId" id="province" onchange="getCityList(this.value)" style="color: #000">
                    </select>&nbsp;&nbsp;省&nbsp;&nbsp;

                    <select name="cityId" id="city" style="color: #000">
                    </select>&nbsp;&nbsp;市
                </div>
            </div>

        </div>
    </div>
</script>
<style>
    .layui-input {
        color: #000;
    }
    .layui-form-label {
        width: 100px;
    }
</style>
</html>
