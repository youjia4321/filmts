<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/21
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>购票系统首页</title>
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.css"/>
  </head>
  <body>
    <%
      if(request.getSession().getAttribute("name") == null) {
        response.sendRedirect("welcome.jsp");
      }
    %>
    <%@include file="header.jsp" %>
    <div class="container">
      <div class="page-header">
        <h1>
          <small>
            <img class="img-circle" src="${avatar}" width="100px" height="100px" alt="">
          </small>
           ${name}
        </h1>
      </div>

      <div class="avatar row clearfix" style="padding: 10px">

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
  <script type="text/html" id="barDemo">
      <button class="layui-btn layui-btn-xs" lay-event="choose">选座</button>
  </script>
  <script type="text/javascript" src="static/js/jquery.min.js"></script>
  <script type="text/javascript">
    $("#logout").click(function() {
      window.location = "UserServlet?action=logout"
    });

  </script>
  <style>
    .page-header {
       padding-bottom: 0;
       margin: 0;
       border-bottom: none;
    }
    .layui-table-page select {
      height: 22px;
    }
  </style>
  <script type="text/javascript" src="static/base/js/movieList.js"></script>
</html>
