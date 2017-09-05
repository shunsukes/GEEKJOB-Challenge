<%-- 
    Document   : challenge16-3-1
    Created on : 2017/08/15, 10:27:26
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
        <form action="./java16-3-1.jsp" method="get">
            <p>総額：<input type="number" name="total">　円</p>
            <p>個数：<input type="number" name="count">　個</p>
            <p>
                商品種別：
                <select name="type">
                    <option value="1">1．雑貨</option>
                    <option value="2">2．生鮮食品</option>
                    <option value="3">3．その他</option>
                </select>
            </p>
            <p><input type="submit" name="btnSubmit"></p>
        </form>       
    </body>
</html>
