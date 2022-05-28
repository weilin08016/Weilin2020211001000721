<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: weilin
  Date: 2022/5/28
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 3 -week 11</title>
</head>
<body>
<%
    // array
    String[] firstName = {"Bill", "Scott", "Larry"};
    // list
    ArrayList<String> lastName = new ArrayList<>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");
    // map
    HashMap<String, String> companyName = new HashMap<>();
    companyName.put("Ellison", "Sun");
    companyName.put("Gates", "Oracle");
    companyName.put("McNealy", "Microsoft");

    // set attribute in anyone scope - we do this in servlet controller in MVC
    session.setAttribute("fName", firstName);
    request.setAttribute("lName", lastName);
    request.setAttribute("cName", companyName);
%>
<h2>Get data from Array(index) --> List(index) --> Map - using EL Code</h2>
<ul>
    <li>${fName[0]} ${lName[0]} --> ${cName["Ellison"]}</li>
    <li>${fName[1]} ${lName[1]} --> ${cName[lName[1]]}</li>
    <li>${fName[2]} ${lName[2]} --> ${cName["McNealy"]}</li>
</ul>
<hr>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Use c:forEach to get items from array</h2>
<ul>
    <c:forEach var="l" items="${fName}">
        <li>${l}</li>
    </c:forEach>
</ul>
</body>
</html>
