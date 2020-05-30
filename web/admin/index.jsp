<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/22
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理首页</title>
</head>
<body>

    <%@include file="adminHeader.jsp" %>

    <div class="container">
        <div class="page-header">
            <h1><span class="glyphicon glyphicon-user"></span> ${name}.admin</h1>
        </div>


        <div class="search input-group input-group-sm" style="width: 350px">
            <span class="input-group-addon">电&nbsp;影&nbsp;搜&nbsp;索</span>
            <input type="text" name="search" id="search" class="form-control" placeholder="输入关键字...">
            <span class="input-group-addon btn" onclick="search()">搜索</span>
        </div><br>
        <table class="layui-hide" id="demo" lay-filter="test"></table>
    </div>

    <%@include file="adminFooter.jsp"%>

</body>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加电影</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <button class="layui-btn layui-btn-xs" lay-event="edit">编辑</button>
    <button class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</button>
</script>

<style>
    .page-header {
        padding-bottom: 10px;

        border-bottom: none;
    }
    .layui-table-page select {
        height: 22px;
    }
</style>
<script type="text/javascript" src="../static/base/js/adminList.js"></script>
</html>
