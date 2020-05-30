<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/21
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cs = request.getCookies();
    if(cs != null) {
        int num = 0;
        for(Cookie cookie: cs) {
            String key = cookie.getName();
            if(key.equals("name") || key.equals("id") || key.equals("avatar") || key.equals("rname")) {
                request.getSession().setAttribute(cookie.getName(), cookie.getValue());
                num++;
            }
        }
        if(num == 4) {
            response.sendRedirect("index.jsp");
        }
    }
%>
