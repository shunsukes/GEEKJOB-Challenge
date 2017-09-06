<%-- 
    Document   : challenge18ci
    Created on : 2017/09/03, 15:47:55
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
        <form target="_blank" action="challenge18ch" method="get">
            <p>プロフィールID：<input type="number" name="profilesID" min="1"></p>
            <p>名前　　　　　：<input type="text" name="name"></p>
            <p>電話番号　　　：<input type="tel" name="tell"></p>
            <p>年齢　　　　　：<input type="number" name="age" min="0"></p>
            <p>誕生日　　　　：<input type="date" name="birthday"></p>
            <p><input type="submit" name="btnSubmit"></p>
        </form>
    </body>
</html>
