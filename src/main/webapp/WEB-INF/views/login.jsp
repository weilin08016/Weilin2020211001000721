<%--
  Created by IntelliJ IDEA.
  User: weilin
  Date: 2022/4/28
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.setAttribute("message")==null)){
        out.println(request.getAttribute("message"));
    }
    Cookie[] allCookies=request.getCookies();
    String username, password , rememberMeval;
    if(allCookies!=null){
        for (Cookie c:allCookies) {
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("rememberMeVal")){
                rememberMeval=c.getValue();
            }
            }//end for
        }//end if
%>


<form>
< method="post" action="login">
    Username :<input type="text" name="username" value="<%=username%>"><br/>
    Password :<input type="password" name="password" value="<%=password%>"><br/>
    <input type="checkbox" value="1" <%=remenerMeVale.equals("1")?checked:""%>checked/>RememberMe<br/>
        <input type="submit" value="Submit"/>
</form>
<%@include file="footer.jsp"%>