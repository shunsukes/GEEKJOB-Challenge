<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    // セッション開始
    HttpSession hs = request.getSession();
    
    UserDataBeans udb = null;
    // 再入力(登録確認画面から戻ってきた)か判定
    boolean reInput = false;
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")) {
        reInput = true;
        udb = (UserDataBeans) hs.getAttribute("udb");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<% if(reInput){ out.print(udb.getName()); } %>">
        <br><br>

        生年月日:　
        <select name="year">
                <option value="">----</option>
                <% for (int i = 1950; i <= 2010; i++) { %>
                    <option value="<%=i%>" <% if(reInput && udb.getYear() == i) { out.print("selected = \"selected\"" ); } %>><%=i%> </option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <% for (int i = 1; i <= 12; i++) {%>
                    <option value="<%=i%>" <% if(reInput && udb.getMonth() == i) { out.print("selected = \"selected\"" ); } %>><%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <% for (int i = 1; i <= 31; i++) {%>
                    <option value="<%=i%>" <% if(reInput && udb.getDay() == i) { out.print("selected = \"selected\"" ); } %>><%=i%></option>
                <% }%>
            </select>日
            <br><br>

            種別:<br>
            <% for(int i = 1; i <= 3; i++) { %>
            <label><input type="radio" name="type" value="<%=i%>" <% if(reInput && udb.getType() == i) { out.print("checked"); } %>><%= jh.exTypenum(i) %></label><br>
            <% } %>
            <br>

            電話番号:
            <input type="text" name="tell" value="<% if(reInput){ out.print(udb.getTell()); } %>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(reInput){ out.print(udb.getComment()); } %></textarea>
            <br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
