<%--
  Created by IntelliJ IDEA.
  User: weilin
  Date: 2022/6/6
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>2020211001000721 weilin</h2>
<h2>Welcome,<%-- todo 8 use c:out to print username from parammeter --%>
    <c:out value='<%=request.getParameter("username")%>'></c:out>
</h2>
</body>
</html>
