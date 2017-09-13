<%@page import="java.util.Calendar"
        import="jums.UserDataDTO"
        import="jums.JumsHelper" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    // セッション開始
    HttpSession hs = request.getSession();
    // 1件のユーザー情報が格納されたセッションデータを取得 [ResultDetail.javaより]
    UserDataDTO udt = (UserDataDTO) hs.getAttribute("resultData");
    // 誕生日を生年・月・日に分けるために、カレンダー型に変換　c.get(Calendar.YEAR)で生年取得
    Calendar c = Calendar.getInstance();
    c.setTime(udt.getBirthday());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
    <form action="UpdateResult" method="POST">
        名前:
        <!--　更新画面で、更新するデータがフォーム内に直接記入されている機能 -->
        <input type="text" name="name" value="<%= udt.getName() %>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% if(c.get(Calendar.YEAR) == i) { out.print("selected = \"selected\""); } %>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(c.get(Calendar.MONTH) +1 == i) { out.print("selected = \"selected\""); } %>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(c.get(Calendar.DAY_OF_MONTH) == i) { out.print("selected = \"selected\""); } %>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>" <% if(udt.getType() == i){ %> checked <% } %>><%=jh.exTypenum(i)%><br>
        <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= udt.getTell() %>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= udt.getComment() %></textarea><br><br>
        
        <!-- ac:不正アクセス防止用データ を[UpdateResult.java]へ送信 -->
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac") %>">
        <!-- id:どのデータを更新するか設定するため、userIDを[UpdateResult.java]へ送信 -->
        <input type="hidden" name="id" value="<%= udt.getUserID() %>">
        <input type="submit" name="btnSubmit" value="確認画面へ" style="width:110px">
    </form>
    <input type="button" value="詳細画面へ戻る" onclick="history.back()" style="width:110px">
    <br><br>
    <%=jh.home()%>
    </body>
</html>
