<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/22
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="../static/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" href="../static/js/layui/css/layui.css">
<script type="text/javascript" src="../static/js/jquery.min.js"></script>
<script type="text/javascript" src="../static/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="../static/bootstrap/js/bootstrap.min.js"></script>

<%@include file="verityIsAdmin.jsp"%>

<div class="layui-layout layui-layout-admin navbar-fixed-top">
    <div class="layui-header">
        <div class="layui-logo">老炮儿后台管理系统</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="index.jsp">后台主页</a></li>
            <li class="layui-nav-item"><a href="../index.jsp">购票首页</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="../${avatar}" class="layui-nav-img" alt="">${name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">修改头像</a></dd>
                    <dd><a href="">基本资料</a></dd>
                    <dd><a id="modifyPwd">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a id="logoutBtnAdmin">退了</a></li>
        </ul>
    </div>
</div>
<script type="text/javascript" src="../static/js/layui/layui.all.js"></script>
<script type="text/javascript" src="../static/js/layui/layui.js"></script>
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
<script type="text/javascript" src="../static/base/js/header.js"></script>