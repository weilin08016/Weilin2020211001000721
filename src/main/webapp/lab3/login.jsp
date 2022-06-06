<%--
  Created by IntelliJ IDEA.
  User: weilin
  Date: 2022/6/6
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>2020211001000721  weilin</h2>
<%-- todo 9: use c:out to print message from request --%>
<c:out value='<%=request.getAttribute("message")%>'></c:out>
<%--todo 1: use c:url to set url in action="validate.jsp" --%>
<form action="<c:url value="validate.jsp"></c:url>">
    Username : <input type="text" name="username"><br>
    Password : <input type="password" name="password"><br>
    <input type="submit" value="Login"/>
</form>
</body>
</html>

