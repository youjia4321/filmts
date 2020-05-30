<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/22
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>电影列表</title>
</head>
<body>

    <%@include file="header.jsp"%>

    <div class="container">
        <div class="page-header">
            <h1><span class="glyphicon glyphicon-user"></span> ${name}
                <small style="font-size: 14px; font-weight: 600">@热门电影</small>
            </h1>
        </div>
        <div class="movies row">
            <div class="search input-group input-group-sm" style="width: 350px">
                <span class="input-group-addon">电&nbsp;影&nbsp;搜&nbsp;索</span>
                <input type="text" name="search" id="search" class="form-control" placeholder="输入关键字...">
                <span class="input-group-addon btn" onclick="search()">搜索</span>
            </div><br>
            <table id="demo" lay-filter="test"></table>
        </div>
    </div>
    <%@include file="footer.jsp"%>
</body>
<style>
    th {
        text-align: center;
    }
    .page-header {
        padding-bottom: 0;
        margin: 0;
        border-bottom: none;
    }
</style>
<script type="text/javascript" src="static/base/js/movieList.js"></script>
</html>
