<%-- 
    Document   : FortuneTellingResult
    Created on : 2017/08/08, 16:59:25
    Author     : maruyamashunsuke
--%>

<%@page import="org.camp.servlet.ResultData" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            ResultData data = (ResultData)request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <%
            if(data != null){
                out.print("<h1>あなたの" + data.getD() + "の運勢は "+data.getLuck()+"です</h>");
            }
        %>
    
</html>
