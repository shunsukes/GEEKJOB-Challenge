<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans) hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
    <% // 全項目が入力されていた場合
           if (!(udb.getName().equals("") || udb.getYear() == 0 || udb.getMonth() == 0 || udb.getDay() == 0
                    || udb.getType() == 0 || udb.getTell().equals("") || udb.getComment().equals(""))) {%>
        <h1>登録確認</h1>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear() + "年" + udb.getMonth() + "月" + udb.getDay() + "日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        <br>
        上記の内容で登録します。よろしいですか？<br>
        <br>
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else {  // 未入力の項目があった場合 %>
            <% if(udb.getName().equals("")) { %>・名前<br><% } %>
            <% if(udb.getYear() == 0 || udb.getMonth() == 0 || udb.getDay() == 0) { %>・生年月日<br><% } %>
            <% if(udb.getType() == 0) { %>・種別<br><% } %>
            <% if(udb.getTell().equals("")) { %>・電話番号<br><% } %>
            <% if(udb.getComment().equals("")) { %>・自己紹介<br><% } %>
    <br>
    上記が入力されていません
    <% } %>
        <form action="insert" method="POST">
            <input type="hidden" name="mode" value="REINPUT">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
