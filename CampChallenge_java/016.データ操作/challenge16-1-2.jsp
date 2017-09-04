<%-- 
    Document   : challenge16-1-2
    Created on : 2017/08/12, 10:26:50
    Author     : maruyamashunsuke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
    
out.print("名前：" + request.getParameter("txtName") + "<br>");
out.print("性別：" + request.getParameter("rdoSample") + "<br>");
out.print("趣味：" + request.getParameter("mulText"));
%>  

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./java16-1-2.jsp" method="post">           
            <p>名前：<input type="text" name="txtName"></p>
            <p>
                性別：
                <input type="radio" name="rdoSample" value="男">男
                <input type="radio" name="rdoSample" value="女">女
            </p>
            <p>趣味：<br><textarea name="mulText" cols="30" rows="10"></textarea></p>
            <p><input type="submit" name="btnSubmit"></p>
        </form>
    </body>
</html>
