<%-- 
    Document   : challenge18Login
    Created on : 2017/09/05, 10:58:23
    Author     : maruyamashunsuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form target="_blank" action="challenge18LoginCheck" method="post">
            <p><input type="text" name="username" placeholder="USERNAME" required></p>
            <p><input type="password" name="password" placeholder="PASSWORD" required></p>
            <p><input type="submit" name="login" value="ログイン"></p>
        </form>
    </body>
</html>
