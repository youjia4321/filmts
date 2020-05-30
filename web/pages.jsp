<%--
  Created by IntelliJ IDEA.
  User: WangSsyu
  Date: 20/5/22
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="${page.url}1">首页</a>
<c:if test="${page.currentPage - 1 > 0 }">
    <a href="${page.url}${page.currentPage - 1}">上一页</a>
</c:if>

<c:if test="${page.currentPage < page.allPage }">
    <a href="${page.url}${page.currentPage + 1}">下一页</a>
</c:if>
<c:if test="${page.currentPage < page.allPage }">
    <a href="${page.url}${page.allPage}">尾页</a>
</c:if>
