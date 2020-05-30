<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/22
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String role = (String) request.getSession().getAttribute("rname");
    if(!role.equals("管理员")) {
        response.sendRedirect("../index.jsp");
    }
%>