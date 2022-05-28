<%--
  Created by IntelliJ IDEA.
  User: weilin
  Date: 2022/5/28
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo-2 week 10</title>
</head>
<body>

<h2>Use bean class in jsp-using java code</h2>
<jsp:useBean id="bean" class="com.weilin.week10.StringBean" /> <!-- scope == page -->
<%
    // using bean
    // com.hanming.week10.StringBean bean = new StringBean();

    // set
    bean.setMessage("Hi mr bean - from java code");
%>

<!-- get message by java code -->
Message(use java code): <%=bean.getMessage()%>

<h2>Use bean class in jso-using useBean, getProperty, setProperty</h2>

<jsp:setProperty name="bean" property="message" value="Hi mr bean - from jsp:setProperty"/>

<!-- get message by jsp:getProperty -->
Message(use getProperty): <jsp:getProperty name="bean" property="message"/>


<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("msg")%>'/>

<!-- get message by jsp:getProperty -->
Message(use getProperty): <jsp:getProperty name="bean" property="message"/>

</body>
</html>
