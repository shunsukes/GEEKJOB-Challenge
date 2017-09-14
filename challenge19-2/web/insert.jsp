<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper"
        import="jums.UserDataBeans" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    
    // セッション開始
    HttpSession hs = request.getSession();
    
    UserDataBeans udb = null;
    boolean reInput = false;
    // 再入力 or 新規入力を判定
    if(request.getParameter("mode") != null && request.getParameter("mode").equals("REINPUT")){
        reInput = true;
        udb = (UserDataBeans)hs.getAttribute("udb");
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
        <!-- 確認画面[insertconfirm.jsp]から戻ってきた場合(変数 reInputがtrue)、フォームを入力済にする -->
        <input type="text" name="name" value="<% if(reInput) { out.print(udb.getName()); } %>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i = 1950; i <= 2010; i++) { %>
            <option value="<%=i%>" <% if(reInput && udb.getYear() == i) { out.print("selected = \"selected\""); } %>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i <= 12; i++){ %>
            <option value="<%=i%>" <% if(reInput && udb.getMonth() == i) { out.print("selected = \"selected\""); } %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++) { %>
            <option value="<%=i%>"<% if(reInput && udb.getDay() == i) { out.print("selected = \"selected\""); } %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:<br>
        <% for(int i = 1; i <= 3; i++) { %>
        <!-- [JumsHelper.java] jh.exTypenum(i)：種別は数字で取り扱っているので画面に表示するときは日本語に変換 -->
        <input type="radio" name="type" value="<%=i%>"<%if(reInput && udb.getType() == i) { out.print("checked = \"checked\""); } %>><%= jh.exTypenum(i) %><br>
        <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<% if(reInput) { out.print(udb.getTell()); } %>">
        <br><br>

        自己紹介文<br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><% if(reInput) { out.print(udb.getComment()); } %></textarea><br><br>
        <!-- ac:不正アクセス防止用データ を[InsertConfirm.java]へ送信 -->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac") %>">
        <!-- 入力情報を[InsertConfirm.java]へPOSTで送信するボタン -->
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=jh.home()%>
    </body>
</html>
