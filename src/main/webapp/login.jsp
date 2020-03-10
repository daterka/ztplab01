<%--
  Created by IntelliJ IDEA.
  User: dtms
  Date: 06.03.2020
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            Name:<input type="text" name="username"/><br/><br/>
            Password:<input type="password" name="userpass"/><br/><br/>
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
