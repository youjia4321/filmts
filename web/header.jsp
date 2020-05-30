<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/22
  Time: 00:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="static/js/layui/css/layui.css">
<link rel="stylesheet" href="static/bootstrap/css/bootstrap.css"/>
<%
    String index="", op3="", user="";
    String role = (String)request.getSession().getAttribute("rname");
    String name = (String)request.getSession().getAttribute("name");
    String avatar = (String)request.getSession().getAttribute("avatar");
    if(role == null) {
        index = "welcome.jsp";
        user = "<li class='layui-nav-item'><a id='loginBtn'>登录</a></li><li class='layui-nav-item'><a id='registerBtn'>注册</a></li>";
    } else {
        index = "index.jsp";
        user = "<li class='layui-nav-item'><a href='#'><img src='"+avatar+"' class='layui-nav-img'>"+name+"</a>" +
                "<dl class='layui-nav-child'><dd><a href=''>修改头像</a></dd><dd><a href=''>基本资料</a></dd>" +
                "<dd><a id='modifyPwd'>修改密码</a>" +
                "</dd></dl></li><li class='layui-nav-item'><a id='logoutBtn'>退了</a></li>";
        if(role.equals("管理员")) {
            op3 = "<li class='layui-nav-item'><a href='admin/index.jsp'>后台管理</a></li>";
        }

    }
%>

<div class="layui-layout layui-layout-admin navbar-fixed-top header-warp">
    <div class="layui-header">
        <div class="layui-logo">老炮儿影院管理系统</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="<%=index%>">主页</a></li>
            <%=op3%>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <%=user%>
        </ul>
    </div>
</div>
<script type="text/javascript" src="static/js/layui/layui.all.js"></script>
<script type="text/javascript" src="static/js/layui/layui.js"></script>
<script type="text/javascript" src="static/js/jquery.min.js"></script>
<script type="text/javascript" src="static/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="static/bootstrap/js/bootstrap.min.js"></script>
<script>
    layui.use('element', function(){
        var element = layui.element;

    });
</script>

<style>
    a {
        cursor: pointer !important;
        text-decoration: none !important;
    }
    .layui-layer {
        top: 150px !important;
    }
    .container {
        margin-top: 50px;
        margin-bottom: 80px;
    }
</style>
<%--<script type="text/javascript" src="static/base/js/province-city.js"></script>--%>
<%--<script type="text/javascript" src="static/js/vue.min.js"></script>--%>
<script type="text/javascript" src="static/base/js/header.js"></script>
