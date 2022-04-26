<%--
  Created by IntelliJ IDEA.
  User: weilin
  Date: 2022/4/23
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<form method="post" action="/register">
        username<input type="text" name="username"/><br>
        password<input type="password" name="password"/><br>
        Email<input type="text" name="email"/><br>
    Gender<input type="radio" name="gender"/>Male<input type="radio" name="gender">female<br>
    Date of Birth :<input type="text name" name="birthDate"><br>
    <input type="submit" name="Register"/>
</form><%@include file="footer.jsp"%>
</body>
</html>
