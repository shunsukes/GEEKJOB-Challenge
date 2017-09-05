<%-- 
    Document   : challenge16-5-2a
    Created on : 2017/08/17, 15:02:21
    Author     : maruyamashunsuke
--%>
<%@page import="javax.servlet.http.HttpSession"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            out.print("名前：" + request.getParameter("txtName") + "<br>");
            out.print("性別：" + request.getParameter("rdoSample") + "<br>");
            out.print("趣味：" + request.getParameter("mulText")+ "<br>");
            HttpSession hs = request.getSession();
            hs.setAttribute("Name", request.getParameter("txtName"));
            hs.setAttribute("Sex", request.getParameter("rdoSample"));
            hs.setAttribute("Hobby", request.getParameter("mulText"));
        %>
    </body>
</html>
