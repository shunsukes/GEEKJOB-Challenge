<%-- 
    Document   : challenge18cl
    Created on : 2017/09/04, 16:13:13
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
        <form target="_blank" action="challenge18cl" method="get">
            <p>名前　：<input type="text" name="name"></p>
            <p>年齢　：<input type="number" name="age" min="0"></p>
            <p>誕生日：<input type="date" name="birthday"></p>
            <select name="search">
                <option value="and">AND</option>
                <option value="or">OR</option>
                <option value="not">NOT</option>
            </select>
            <p><input type="submit" name="btnSubmit" value="検索"></p>
        </form>
    </body>
</html>
