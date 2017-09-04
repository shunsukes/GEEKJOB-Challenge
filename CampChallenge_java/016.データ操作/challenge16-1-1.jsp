<%-- 
    Document   : challenge16-1-1
    Created on : 2017/08/12, 10:26:28
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
        <form action="./java16-1-1.jsp" method="post">
            
            <p>名前：<input type="text" name="txtName"></p>
            <p>
                性別：
                <input type="radio" name="rdoSample" value="男">男
                <input type="radio" name="rdoSample" value="女">女
            </p>
            <p>趣味：<br><textarea name="mulText" cols="30" rows="10"></textarea></p>
        </form>
    </body>
</html>
